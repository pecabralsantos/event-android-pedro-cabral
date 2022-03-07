package br.com.cabral.eventos.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.cabral.eventos.R
import br.com.cabral.eventos.databinding.ItemCardHomeBinding
import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.ui.util.Formats
import com.squareup.picasso.Picasso


class EventsHomeAdapter() : RecyclerView.Adapter<EventsHomeAdapter.ViewHolder>() {

    private var listEvents = listOf<Event>()

    class ViewHolder(val binding: ItemCardHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        LayoutInflater.from(parent.context).apply {
            return ViewHolder(ItemCardHomeBinding.inflate(this, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.get()
            .load(listEvents[position].image)
            .placeholder(R.drawable.ic_empty_image)
            .error(R.drawable.ic_empty_image)
            .into(holder.binding.ivEvent)

        holder.binding.txtEventDate.text = Formats().longToDateSimplified(listEvents[position].date)
        holder.binding.txtEventTitle.text = listEvents[position].title
    }

    override fun getItemCount(): Int = listEvents.size

    fun update(listEvents: List<Event>) {
        this.listEvents = listEvents
        notifyDataSetChanged()
    }

}
