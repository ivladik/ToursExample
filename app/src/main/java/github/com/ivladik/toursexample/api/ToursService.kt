package github.com.ivladik.toursexample.api

import github.com.ivladik.toursexample.model.AirlinesResponse
import github.com.ivladik.toursexample.model.FlightsResponse
import github.com.ivladik.toursexample.model.HotelsResponse
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * @author Vladislav Falzan.
 */
interface ToursService {

    @GET("/bins/zqxvw")
    fun getFlights(): Flowable<FlightsResponse>

    @GET("/bins/12q3ws")
    fun getHotels(): Flowable<HotelsResponse>

    @GET("/bins/8d024")
    fun getAirlines(): Flowable<AirlinesResponse>
}