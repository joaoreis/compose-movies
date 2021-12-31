package br.com.jxr.composemovies.di

import br.com.jxr.composemovies.DefaultDispatcherProvider
import br.com.jxr.composemovies.DispatcherProvider
import br.com.jxr.composemovies.data.RemoteApiBuilder
import br.com.jxr.composemovies.data.api.TheMovieDbApi
import br.com.jxr.composemovies.data.remote.TheMovieDbDataSource
import br.com.jxr.composemovies.data.remote.TheMovieDbRemoteDataSource
import org.koin.dsl.module

private const val BaseUrl = "https://api.themoviedb.org/3/"

val dataModule = module {

    factory<DispatcherProvider> { DefaultDispatcherProvider() }

    factory<TheMovieDbApi> { RemoteApiBuilder.buildService(BaseUrl) }

    factory<TheMovieDbDataSource> {
        TheMovieDbRemoteDataSource(
            api = get(),
            dispatcher = get()
        )
    }
}
