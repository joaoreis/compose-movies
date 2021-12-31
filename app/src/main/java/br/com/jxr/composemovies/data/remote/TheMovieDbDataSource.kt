package br.com.jxr.composemovies.data.remote

import br.com.jxr.composemovies.data.model.MovieDto
import br.com.jxr.composemovies.data.model.PopularMoviesResponse

interface TheMovieDbDataSource {
    suspend fun getMovie(movieId: Int): MovieDto
    suspend fun getPopular(page: Int = 1): PopularMoviesResponse
}
