package br.com.jxr.composemovies.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDto(
    val title: String,
    val poster_path: String?,
    val backdrop_path: String?
) : Parcelable
