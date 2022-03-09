package br.com.cabral.eventos.repository

import br.com.cabral.eventos.model.CheckIn
import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.service.EventsApiModule
import okhttp3.ResponseBody
import retrofit2.Response

interface EventsRepository {
    suspend fun getAllEvents(): Response<List<Event>>
    suspend fun getEvent(id: String): Response<Event>
    suspend fun setCheckIn(checkIn: CheckIn): Response<ResponseBody>
}

class EventsRepositoryImpl(
    private val eventsApi: EventsApiModule
) : EventsRepository {

    override suspend fun getAllEvents(): Response<List<Event>> =
        eventsApi.networkProvider().getAllEvents()

    override suspend fun getEvent(id: String): Response<Event> =
        eventsApi.networkProvider().getEvent(id)

    override suspend fun setCheckIn(checkIn: CheckIn): Response<ResponseBody> =
        eventsApi.networkProvider().setCheckIn(checkIn)

}