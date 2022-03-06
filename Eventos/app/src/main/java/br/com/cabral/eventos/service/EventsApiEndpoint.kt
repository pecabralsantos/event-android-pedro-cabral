package br.com.cabral.eventos.service

import br.com.cabral.eventos.model.CheckIn
import br.com.cabral.eventos.model.Event
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsApiEndpoint {

    @GET("api/events")
    suspend fun getAllEvents(): Response<List<Event>>

    @GET("api/events/{id}")
    suspend fun getEvent(@Path("id") id: String): Response<Event>

    @POST("api/checkin")
    suspend fun setCheckIn(@Body checkIn: CheckIn): Response<ResponseBody>

}