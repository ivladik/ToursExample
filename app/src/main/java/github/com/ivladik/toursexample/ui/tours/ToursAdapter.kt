package github.com.ivladik.toursexample.ui.tours

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import github.com.ivladik.toursexample.R
import github.com.ivladik.toursexample.model.Tour
import github.com.ivladik.toursexample.utils.inflate
import kotlinx.android.synthetic.main.li_tour.view.*

/**
 * @author Vladislav Falzan.
 */
class ToursAdapter(onClickListener: OnItemClickListener) : RecyclerView.Adapter<ToursAdapter.ToursHolder>() {

    var items: List<Tour> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private val internalClickListener = View.OnClickListener {
        val position = it.tag as Int
        onClickListener.onItemClick(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToursHolder {
        return ToursHolder(parent.inflate(R.layout.li_tour))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ToursHolder, position: Int) {
        holder.bind(items[position], position)
    }

    interface OnItemClickListener {

        fun onItemClick(tour: Tour)
    }

    inner class ToursHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(tour: Tour, position: Int) {
            with(itemView) {
                hotelName.text = tour.hotelName
                possibleFlights.text = tour.possibleFlights
                minimalPrice.text = tour.minimalPrice
                tag = position
                container.setOnClickListener(internalClickListener)
            }
        }
    }
}