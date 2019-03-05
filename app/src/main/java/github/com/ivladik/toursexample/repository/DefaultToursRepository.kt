package github.com.ivladik.toursexample.repository

import github.com.ivladik.toursexample.api.ToursService
import github.com.ivladik.toursexample.model.*
import github.com.ivladik.toursexample.utils.RxUtils
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author Vladislav Falzan.
 */
class DefaultToursRepository @Inject constructor(private val toursService: ToursService) : ToursRepository {

    override fun getFlights(): Flowable<FlightsResponse> {
        return toursService.getFlights()
            .compose(RxUtils.async())
    }

    override fun getHotels(): Flowable<HotelsResponse> {
        return toursService.getHotels()
            .compose(RxUtils.async())
    }

    override fun getAirlines(): Flowable<AirlinesResponse> {
        return toursService.getAirlines()
            .compose(RxUtils.async())
    }
}