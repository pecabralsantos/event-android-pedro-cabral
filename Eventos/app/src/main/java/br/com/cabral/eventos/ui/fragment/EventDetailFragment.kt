package br.com.cabral.eventos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.cabral.eventos.R
import br.com.cabral.eventos.databinding.FragmentEventDetailBinding
import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.ui.util.Formats
import br.com.cabral.eventos.ui.viewmodel.EventDetailViewModel
import com.squareup.picasso.Picasso
import org.koin.android.ext.android.inject

class EventDetailFragment : Fragment() {

    private lateinit var binding: FragmentEventDetailBinding
    private val viewModel: EventDetailViewModel by inject()

    companion object {
        const val ID_SELECTED_EVENT = "ID_SELECTED_EVENT"
    }

    private val idEvent: String by lazy {
        arguments?.getString(ID_SELECTED_EVENT) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentEventDetailBinding.inflate(inflater, container, false).let {
        binding = it
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()

        viewModel.getEvent(idEvent)
    }

    private fun setupObservers() {
        viewModel.event.observe(viewLifecycleOwner) {
            configEventDetails(it)
        }
    }

    private fun configEventDetails(detail: Event?) {
        Picasso.get()
            .load(detail?.image)
            .placeholder(R.drawable.ic_empty_image)
            .error(R.drawable.ic_empty_image)
            .into(binding.ivDetailImg)

        binding.txtDetailTitle.text = detail?.title
        binding.txtDetailDate.text = Formats().longToDateExtensive(detail?.date)
        binding.txtDetailPrice.text = Formats().money(detail?.price?.toBigDecimal())
        binding.txtDetailDescription.text = detail?.description
    }

}