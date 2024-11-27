package com.example.app_catalago_de_filmes.data.repository

import com.example.app_catalago_de_filmes.data.api.MovieApiService
import com.example.app_catalago_de_filmes.data.model.Movie
import retrofit2.Response

class MovieRepository(private val movieApiService: MovieApiService): IMovieRepository {


    override suspend fun getPopularMovies(apiKey: String): Response<List<Movie>> {
        return movieApiService.getPopularMovies(apiKey)
    }

    override suspend fun searchMovies(apiKey: String, query: String): Response<List<Movie>> {
        return movieApiService.searchMovies(apiKey, query)
    }
}
