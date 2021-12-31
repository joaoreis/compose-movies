package br.com.jxr.composemovies.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.jxr.composemovies.domain.entities.Movie
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

sealed class MainUiState {

    @Composable
    abstract fun BuildUI()

    @ExperimentalCoilApi
    class Success(private val movies: List<Movie>) : MainUiState() {

        @Composable
        override fun BuildUI() = ShowImages(movies)

        @Composable
        private fun ShowImages(movies: List<Movie>) {
            Column(
                Modifier
                    .fillMaxSize()
                    .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
            ) {

                movies.forEach {
                    Row(Modifier.fillMaxWidth()) {
                        PosterImage(url = it.posterPath)
                    }
                }
            }
        }

        @ExperimentalCoilApi
        @Composable
        private fun PosterImage(url: String) {
            val baseUrl = "https://image.tmdb.org/t/p/w500"
            Image(
                painter = rememberImagePainter(baseUrl + url),
                contentDescription = null,
            )
        }
    }

    class Error(val exception: Throwable) : MainUiState() {

        @Composable
        override fun BuildUI() {
            // Show an error dialog
        }
    }
}
