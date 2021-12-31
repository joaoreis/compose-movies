package br.com.jxr.composemovies.data.remote

import br.com.jxr.composemovies.di.dataModule
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

private const val default_results_size = 20

@ExperimentalCoroutinesApi
internal class TheMovieDbRemoteDataSourceTest : KoinTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val dataSource: TheMovieDbDataSource by inject()

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

    @Test
    fun `getPopular() should return a list of movies`() {
        testDispatcher.runBlockingTest {
            val movies = dataSource.getPopular()
            movies.results shouldHaveSize default_results_size
        }
    }

    @Test
    fun `getPopular() with a page should return a list of movies from that page`() {
        val page = 2
        runBlocking {
            val popularMoviesResponse = dataSource.getPopular(page)
            popularMoviesResponse.page shouldBe page
            popularMoviesResponse.results shouldHaveSize default_results_size
        }
    }
}
