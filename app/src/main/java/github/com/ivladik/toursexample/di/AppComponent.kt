package github.com.ivladik.toursexample.di

import dagger.Component
import github.com.ivladik.toursexample.ui.tours.ToursPresenter
import javax.inject.Singleton

/**
 * @author Vladislav Falzan.
 */
@Singleton
@Component(modules = [DataModule::class])
interface AppComponent {

    fun injectToursPresenter(toursPresenter: ToursPresenter)
}