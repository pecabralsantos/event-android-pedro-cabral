package br.com.cabral.eventos.repository

import br.com.cabral.eventos.model.Event
import br.com.cabral.eventos.service.EventsApiModule
import retrofit2.Response

interface EventsRepository {
    suspend fun getAllEvents(): Response<List<Event>>
}

class EventsRepositoryImpl(
    private val eventsApi: EventsApiModule
) : EventsRepository {

    override suspend fun getAllEvents(): Response<List<Event>> =
        eventsApi.networkProvider().getAllEvents()

}