package br.com.jxr.composemovies.data

import br.com.jxr.composemovies.data.remote.TheMovieDbDataSource
import br.com.jxr.composemovies.domain.entities.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MoviesRepository(
    private val dataSource: TheMovieDbDataSource,
    private val mapper: PopularMoviesResponseMapper
) {
    suspend fun getPopularMovies(): Flow<List<Movie>> {
        val result = dataSource.getPopular().results
            .map { mapper.map(it) }

        // kinda random but ok
        return flowOf(result)
    }
}
