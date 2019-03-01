package github.com.ivladik.toursexample.api

import github.com.ivladik.toursexample.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Vladislav Falzan.
 */
class ServiceProvider private constructor() {

    companion object {

        val toursService: ToursService by lazy {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.API_ENDPOINT)
                .build()

            retrofit.create(ToursService::class.java)
        }
    }
}