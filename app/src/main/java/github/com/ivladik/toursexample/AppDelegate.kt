package github.com.ivladik.toursexample

import android.app.Application
import github.com.ivladik.toursexample.di.AppComponent
import github.com.ivladik.toursexample.di.DaggerAppComponent
import github.com.ivladik.toursexample.di.DataModule

/**
 * @author Vladislav Falzan.
 */
class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .dataModule(DataModule(this))
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent private set
    }
}