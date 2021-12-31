package br.com.jxr.composemovies

import android.app.Application
import br.com.jxr.composemovies.di.dataModule
import br.com.jxr.composemovies.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TheMovieDbApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            val logLevel = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE
            androidLogger(logLevel)
            androidContext(this@TheMovieDbApplication)
            modules(
                dataModule,
                presentationModule
            )
        }
    }
}
