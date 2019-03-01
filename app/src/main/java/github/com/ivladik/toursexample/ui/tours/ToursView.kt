package github.com.ivladik.toursexample.ui.tours

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import github.com.ivladik.toursexample.model.Tour

/**
 * @author Vladislav Falzan.
 */
@StateStrategyType(AddToEndStrategy::class)
interface ToursView : MvpView {

    fun showTours(tours: List<Tour>)
}