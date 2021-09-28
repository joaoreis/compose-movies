package br.com.jxr.composemovies.di

import br.com.jxr.composemovies.data.RemoteApiBuilder
import br.com.jxr.composemovies.data.TheMovieDbApi
import org.koin.dsl.module

private const val BaseUrl = "https://api.themoviedb.org/3/"

val dataModule = module {

    factory<TheMovieDbApi> { RemoteApiBuilder.buildService(BaseUrl) }
}
