package br.com.jxr.composemovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jxr.composemovies.data.MoviesRepository
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoilApi
class MainViewModel(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState.Success(emptyList()))
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        viewModelScope.launch {
            moviesRepository.getPopularMovies()
                .collect { movies ->
                    _uiState.value = MainUiState.Success(movies)
                }
        }
    }
}
