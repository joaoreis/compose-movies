package br.com.jxr.composemovies.data.remote

import br.com.jxr.composemovies.DispatcherProvider
import br.com.jxr.composemovies.data.api.TheMovieDbApi
import br.com.jxr.composemovies.data.model.MovieDto
import br.com.jxr.composemovies.data.model.PopularMoviesResponse
import kotlinx.coroutines.withContext

class TheMovieDbRemoteDataSource(
    private val dispatcher: DispatcherProvider,
    private val api: TheMovieDbApi
) : TheMovieDbDataSource {

    override suspend fun getMovie(movieId: Int): MovieDto {
        return withContext(dispatcher.io()) {
            api.getMovie(movieId)
        }
    }

    override suspend fun getPopular(page: Int): PopularMoviesResponse {
        return withContext(dispatcher.io()) {
            api.getPopular(page)
        }
    }
}
