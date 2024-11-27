package com.example.app_catalago_de_filmes.data.repository

import com.example.app_catalago_de_filmes.data.model.Movie
import retrofit2.Response

interface IMovieRepository {

    suspend fun getPopularMovies(apiKey: String): Response<List<Movie>>

    suspend fun searchMovies(apiKey: String, query: String): Response<List<Movie>>
}