package br.com.cabral.eventos.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsApiModule {

    companion object {
        private const val BASE_URL = "https://5f5a8f24d44d640016169133.mockapi.io/"
    }

    fun networkProvider(): EventsApiEndpoint {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EventsApiEndpoint::class.java)
    }

}