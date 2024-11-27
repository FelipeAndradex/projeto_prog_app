package com.example.app_catalago_de_filmes.di

import com.example.app_catalago_de_filmes.Rest
import com.example.app_catalago_de_filmes.data.api.MovieApiService
import com.example.app_catalago_de_filmes.data.repository.IMovieRepository
import com.example.app_catalago_de_filmes.data.repository.MovieRepository
import com.example.app_catalago_de_filmes.viewmodel.MovieViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    single { Rest.api }

    single <MovieApiService>{ get<Retrofit>().create(MovieApiService::class.java) }

    single <IMovieRepository>{ MovieRepository(get()) }

    viewModel { MovieViewModel(get()) }
}
