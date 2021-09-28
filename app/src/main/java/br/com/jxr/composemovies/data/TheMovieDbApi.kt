package br.com.jxr.composemovies.data

import br.com.jxr.composemovies.BuildConfig
import br.com.jxr.composemovies.data.model.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDbApi {

    @GET("movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") id: Int,
        @Query("api_key") key: String = BuildConfig.TmdbApiKey
    ): MovieDto

//    @GET("/movie/popular")
//    suspend fun getMovie(): List<Movie>
}
