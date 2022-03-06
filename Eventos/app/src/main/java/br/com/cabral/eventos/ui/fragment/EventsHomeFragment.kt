package br.com.cabral.eventos.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cabral.eventos.databinding.FragmentEventsHomeBinding
import br.com.cabral.eventos.ui.adapter.EventsHomeAdapter
import br.com.cabral.eventos.ui.viewmodel.EventsHomeViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsHomeFragment : Fragment() {

    private lateinit var binding: FragmentEventsHomeBinding
    private val eventsHomeViewModel: EventsHomeViewModel by inject()

    private val adapterEvents: EventsHomeAdapter by lazy { EventsHomeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentEventsHomeBinding.inflate(inflater, container, false).let {
        binding = it
        binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupAdapter()

        eventsHomeViewModel.getAllEvents()
    }

    private fun setupObservers() {
        eventsHomeViewModel.listEvents.observe(viewLifecycleOwner) {
            adapterEvents.update(it)
        }
    }

    private fun setupAdapter() {
        with(binding.rvListEvents) {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterEvents
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }
    }

}