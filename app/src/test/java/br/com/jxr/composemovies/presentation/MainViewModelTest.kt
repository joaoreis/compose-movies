package br.com.jxr.composemovies.presentation

import br.com.jxr.composemovies.di.dataModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.koin.core.context.startKoin
import org.koin.test.KoinTest

@ExperimentalCoroutinesApi
internal class MainViewModelTest : KoinTest {
    private val testDispatcher = TestCoroutineDispatcher()
//    private val viewModel: MainViewModel by viewModel

    @BeforeAll
    fun initialize() {
        startKoin {
            modules(
                dataModule
            )
        }
    }

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
