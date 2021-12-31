package br.com.jxr.composemovies.data.api

import br.com.jxr.composemovies.BuildConfig
import br.com.jxr.composemovies.data.model.MovieDto
import br.com.jxr.composemovies.data.model.PopularMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String = BuildConfig.TmdbApiKey
    ): MovieDto

    @GET("movie/popular")
    suspend fun getPopular(
        @Query("page") id: Int,
        @Query("api_key") key: String = BuildConfig.TmdbApiKey
    ): PopularMoviesResponse
}
