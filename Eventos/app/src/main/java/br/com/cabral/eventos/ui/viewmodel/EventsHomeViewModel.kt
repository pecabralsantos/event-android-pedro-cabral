package br.com.cabral.eventos.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.repository.EventsRepository
import kotlinx.coroutines.launch

class EventsHomeViewModel(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData(true)
    val listEvents: MutableLiveData<List<Event>> = MutableLiveData()

    fun getAllEvents() {
        viewModelScope.launch {
            val response = eventsRepository.getAllEvents()
            if (response.isSuccessful) {
                loading.value = false
                listEvents.value = response.body()
            } else {
                loading.value = false
                Log.e("ERROR", response.message())
            }
        }
    }

}