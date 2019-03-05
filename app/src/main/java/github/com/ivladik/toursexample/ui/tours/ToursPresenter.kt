package github.com.ivladik.toursexample.ui.tours

import android.annotation.SuppressLint
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import github.com.ivladik.toursexample.AppDelegate
import github.com.ivladik.toursexample.R
import github.com.ivladik.toursexample.model.Flight
import github.com.ivladik.toursexample.model.Hotel
import github.com.ivladik.toursexample.model.Tour
import github.com.ivladik.toursexample.repository.ToursRepository
import github.com.ivladik.toursexample.utils.resources.ResourcesHandler
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

/**
 * @author Vladislav Falzan.
 */
@InjectViewState
class ToursPresenter : MvpPresenter<ToursView>() {

    @Inject
    lateinit var repository: ToursRepository

    @Inject
    lateinit var resourcesHandler: ResourcesHandler

    private val tag = javaClass.simpleName

    override fun onFirstViewAttach() {
        loadTours()
    }

    @SuppressLint("CheckResult")
    private fun loadTours() {
        val flightsFlowable = repository.getFlights().map { it.flights }
        val hotelsFlowable = repository.getHotels().map { it.hotels }
        val airlinesFlowable = repository.getAirlines().map { it.airlines } // TODO: to process

        val toursFlowable = Flowable.zip<List<Flight>, List<Hotel>, List<Tour>>(
            flightsFlowable,
            hotelsFlowable,
            BiFunction { flights, hotels ->
                createToursModel(flights, hotels)
            }
        )
        toursFlowable.subscribe(
            { tours -> viewState.showTours(tours) },
            { throwable -> Log.d(tag, throwable.message, throwable) }
        )
    }

    private fun createToursModel(
        flights: List<Flight>,
        hotels: List<Hotel>
    ): List<Tour> {
        return hotels.map { hotel ->
            val availableFlightsForHotel = hotel.flightsIds.size
            val flightsRelatedToHotel = flights.filter { hotel.flightsIds.contains(it.id) }
            val minimalPrice = resolveMinimalPrice(hotel, flightsRelatedToHotel)
            Tour(
                hotel.name,
                formatAvailableFlightsForHotel(availableFlightsForHotel),
                formatMinimalPrice(availableFlightsForHotel, minimalPrice)
            )
        }
    }

    private fun formatAvailableFlightsForHotel(availableFlights: Int): String {
        return resourcesHandler.getQuantityString(R.plurals.possibleFlights, availableFlights, availableFlights)
    }

    private fun formatMinimalPrice(availableFlights: Int, minimalPrice: Int): String {
        return resourcesHandler.getQuantityString(R.plurals.minimalPrice, availableFlights, minimalPrice)
    }

    private fun resolveMinimalPrice(hotel: Hotel, flights: List<Flight>): Int {
        val flightWithMinimalPrice = flights.minBy { it.price }
            ?.price
            ?: return 0
        return hotel.price + flightWithMinimalPrice
    }

    init {
        AppDelegate.appComponent.injectToursPresenter(this)
    }
}