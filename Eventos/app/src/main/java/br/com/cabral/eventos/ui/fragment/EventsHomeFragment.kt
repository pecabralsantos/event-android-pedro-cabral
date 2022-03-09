package br.com.cabral.eventos.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cabral.eventos.databinding.FragmentEventsHomeBinding
import br.com.cabral.eventos.ui.adapter.EventsHomeAdapter
import br.com.cabral.eventos.ui.util.DialogUtils
import br.com.cabral.eventos.ui.viewmodel.EventsHomeViewModel
import org.koin.android.ext.android.inject

class EventsHomeFragment : Fragment() {

    private lateinit var binding: FragmentEventsHomeBinding
    private val viewModel: EventsHomeViewModel by inject()

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

        viewModel.getAllEvents()
    }

    private fun setupObservers() {
        viewModel.loading.observe(viewLifecycleOwner) {
            if (!it) binding.progressBar.visibility = View.GONE
            else binding.rvListEvents.visibility = View.VISIBLE
        }

        viewModel.listEvents.observe(viewLifecycleOwner) {
            adapterEvents.update(it)
        }

        viewModel.postError.observe(viewLifecycleOwner) {
            if (it) DialogUtils.alert(
                requireContext()
            ) { dialog, _ ->
                viewModel.postError.value = false
                dialog.dismiss()
            }
        }
    }

    private fun setupAdapter() {
        with(binding.rvListEvents) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterEvents
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
        }
    }

}