package br.com.jxr.composemovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import br.com.jxr.composemovies.presentation.MainViewModel
import br.com.jxr.composemovies.ui.theme.ComposeMoviesTheme
import coil.annotation.ExperimentalCoilApi
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    fun MainScreen() {
        val viewState = viewModel.uiState.collectAsState()
        viewState.value.BuildUI()
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeMoviesTheme {
            MainScreen()
        }
    }
}
