package github.com.ivladik.toursexample.repository

import github.com.ivladik.toursexample.api.ServiceProvider
import github.com.ivladik.toursexample.model.*
import github.com.ivladik.toursexample.utils.RxUtils
import io.reactivex.Flowable

/**
 * @author Vladislav Falzan.
 */
class DefaultToursRepository : ToursRepository {

    override fun getFlights(): Flowable<FlightsResponse> {
        return ServiceProvider.toursService
            .getFlights()
            .compose(RxUtils.async())
    }

    override fun getHotels(): Flowable<HotelsResponse> {
        return ServiceProvider.toursService
            .getHotels()
            .compose(RxUtils.async())
    }

    override fun getAirlines(): Flowable<AirlinesResponse> {
        return ServiceProvider.toursService
            .getAirlines()
            .compose(RxUtils.async())
    }
}