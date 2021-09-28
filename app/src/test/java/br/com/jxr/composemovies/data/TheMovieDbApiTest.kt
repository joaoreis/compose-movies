package br.com.jxr.composemovies.data

import br.com.jxr.composemovies.di.dataModule
import io.kotest.matchers.shouldNotBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@ExperimentalCoroutinesApi
internal class TheMovieDbApiTest : KoinTest {

    private val api: TheMovieDbApi by inject()

    @BeforeAll
    fun setup() {
        startKoin {
            modules(
                dataModule
            )
        }
    }

    @Test
    fun testApi() {
        runBlocking {
            val movie = api.getMovie(550)
            movie shouldNotBe null
        }
    }
}
