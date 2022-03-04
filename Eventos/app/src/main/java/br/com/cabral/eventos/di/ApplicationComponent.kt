package br.com.cabral.eventos.di

import android.app.Application
import br.com.cabral.eventos.di.scope.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationComponent : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationComponent)
            modules(appModule)
        }
    }

}