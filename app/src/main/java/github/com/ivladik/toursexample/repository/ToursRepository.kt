package github.com.ivladik.toursexample.repository

import github.com.ivladik.toursexample.model.AirlinesResponse
import github.com.ivladik.toursexample.model.FlightsResponse
import github.com.ivladik.toursexample.model.HotelsResponse
import github.com.ivladik.toursexample.model.Tour
import io.reactivex.Flowable

/**
 * @author Vladislav Falzan.
 */
interface ToursRepository {

    fun getFlights(): Flowable<FlightsResponse>

    fun getHotels(): Flowable<HotelsResponse>

    fun getAirlines(): Flowable<AirlinesResponse>
}