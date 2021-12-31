package br.com.jxr.composemovies.data

import br.com.jxr.composemovies.data.model.MovieDto
import br.com.jxr.composemovies.domain.entities.Movie

class PopularMoviesResponseMapper {

    fun map(movieDto: MovieDto): Movie {
        return Movie(
            movieDto.title,
            movieDto.poster_path.orEmpty(),
            movieDto.backdrop_path.orEmpty()
        )
    }
}
