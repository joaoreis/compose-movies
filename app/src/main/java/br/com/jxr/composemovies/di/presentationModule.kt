package br.com.jxr.composemovies.di

import br.com.jxr.composemovies.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel(moviesRepository = get()) }
}
