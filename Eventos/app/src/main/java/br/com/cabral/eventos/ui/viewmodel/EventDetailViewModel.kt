package br.com.cabral.eventos.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.repository.EventsRepository
import kotlinx.coroutines.launch

class EventDetailViewModel(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    val event: MutableLiveData<Event> = MutableLiveData()

    fun getEvent(id: String) {
        viewModelScope.launch {
            val response = eventsRepository.getEvent(id)
            if (response.isSuccessful) {
                event.value = response.body()
            } else {
                Log.e("ERROR", response.message())
            }
        }
    }

}