package br.com.jxr.composemovies.domain

import br.com.jxr.composemovies.data.MoviesRepository
import br.com.jxr.composemovies.di.dataModule
import br.com.jxr.composemovies.domain.entities.Movie
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.should
import io.kotest.matchers.string.shouldNotBeBlank
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@ExperimentalCoroutinesApi
internal class MoviesRepositoryTest : KoinTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val repository: MoviesRepository by inject()

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
    fun `Repository getPopularMovies should return a list of movies`() {
        runBlocking {
            val actual = repository.getPopularMovies()
            actual.shouldBeInstanceOf<List<Movie>>()
            actual shouldHaveAtLeastSize 10
            actual.first().should {
                it.title.shouldNotBeBlank()
                it.posterPath.shouldNotBeBlank()
                it.backdropPath.shouldNotBeBlank()
            }
        }
    }
}
