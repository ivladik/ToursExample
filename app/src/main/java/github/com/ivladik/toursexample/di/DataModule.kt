package github.com.ivladik.toursexample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import github.com.ivladik.toursexample.BuildConfig
import github.com.ivladik.toursexample.api.ToursService
import github.com.ivladik.toursexample.repository.DefaultToursRepository
import github.com.ivladik.toursexample.repository.ToursRepository
import github.com.ivladik.toursexample.utils.resources.ContextResourcesHandler
import github.com.ivladik.toursexample.utils.resources.ResourcesHandler
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Vladislav Falzan.
 */
@Module
class DataModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideResourcesHandler(context: Context): ResourcesHandler = ContextResourcesHandler(context)

    @Provides
    @Singleton
    fun provideToursRepository(toursService: ToursService): ToursRepository = DefaultToursRepository(toursService)

    @Provides
    @Singleton
    fun provideToursService(retrofit: Retrofit): ToursService = retrofit.create(ToursService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.API_ENDPOINT)
            .build()
    }
}