package github.com.ivladik.toursexample.ui.tours

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import github.com.ivladik.toursexample.R
import github.com.ivladik.toursexample.model.Tour
import github.com.ivladik.toursexample.repository.RepositoryProvider
import github.com.ivladik.toursexample.utils.resources.ContextResourcesHandler
import kotlinx.android.synthetic.main.ac_tours.*

class ToursActivity : MvpAppCompatActivity(), ToursView, ToursAdapter.OnItemClickListener {

    @InjectPresenter
    lateinit var presenter: ToursPresenter

    @ProvidePresenter
    fun providePresenter() = ToursPresenter(RepositoryProvider.instance, ContextResourcesHandler.newInstance(this))

    private val adapter: ToursAdapter by lazy { ToursAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_tours)
        initRecycler()
    }

    private fun initRecycler() {
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    override fun showTours(tours: List<Tour>) {
        adapter.items = tours
    }

    override fun onItemClick(tour: Tour) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
