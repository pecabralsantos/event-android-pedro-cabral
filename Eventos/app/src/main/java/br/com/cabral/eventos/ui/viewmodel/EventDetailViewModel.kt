package br.com.cabral.eventos.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cabral.eventos.model.CheckIn
import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.repository.EventsRepository
import kotlinx.coroutines.launch

class EventDetailViewModel(
    private val eventsRepository: EventsRepository
) : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData(true)
    val event: MutableLiveData<Event> = MutableLiveData()
    val postSuccess: MutableLiveData<Boolean> = MutableLiveData(false)
    val postError: MutableLiveData<Boolean> = MutableLiveData(false)

    fun getEvent(id: String) {
        viewModelScope.launch {
            val response = eventsRepository.getEvent(id)
            if (response.isSuccessful) {
                loading.value = false
                event.value = response.body()
            } else {
                loading.value = false
                postError.value = true
                Log.e("ERROR", response.message())
            }
        }
    }

    fun setCheckIn(checkIn: CheckIn) {
        viewModelScope.launch {
            loading.value = true
            val response = eventsRepository.setCheckIn(checkIn)
            if (response.isSuccessful) {
                loading.value = false
                postSuccess.value = true
            } else {
                loading.value = false
                postError.value = true
                Log.e("ERROR", response.message())
            }
        }
    }

}