package br.com.jxr.composemovies.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PopularMoviesResponse(
    val page: Int,
    val results: List<MovieDto>
) : Parcelable
