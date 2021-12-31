package br.com.jxr.composemovies.data

import br.com.jxr.composemovies.data.remote.TheMovieDbDataSource
import br.com.jxr.composemovies.domain.entities.Movie

class MoviesRepository(
    private val dataSource: TheMovieDbDataSource,
    private val mapper: PopularMoviesResponseMapper
) {
    suspend fun getPopularMovies(): List<Movie> {
        return dataSource.getPopular().results
            .map { mapper.map(it) }
    }
}
