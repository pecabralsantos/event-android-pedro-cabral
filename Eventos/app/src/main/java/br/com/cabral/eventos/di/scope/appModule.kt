package br.com.cabral.eventos.di.scope

import br.com.cabral.eventos.repository.EventsRepository
import br.com.cabral.eventos.repository.EventsRepositoryImpl
import br.com.cabral.eventos.service.EventsApiModule
import br.com.cabral.eventos.ui.viewmodel.EventsHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { EventsApiModule() }

    single<EventsRepository> { EventsRepositoryImpl(get()) }

    viewModel { EventsHomeViewModel(get()) }

}