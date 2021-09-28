package br.com.jxr.composemovies.di

import br.com.jxr.composemovies.TheMovieDbApplication
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.koin.android.ext.koin.androidContext
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class CheckModulesTest : KoinTest {

    private val application = mockk<TheMovieDbApplication>()

    @Test
    fun checkAllModules() = checkModules {
        androidContext(application)
        modules(dataModule)
    }
}
