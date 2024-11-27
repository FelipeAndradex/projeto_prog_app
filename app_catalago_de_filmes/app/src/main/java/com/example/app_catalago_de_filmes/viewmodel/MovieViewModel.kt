package com.example.app_catalago_de_filmes.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_catalago_de_filmes.data.model.Movie
import com.example.app_catalago_de_filmes.data.repository.IMovieRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MovieViewModel(private val movieRepository: IMovieRepository) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<Movie>>(emptyList())
    val searchResults: StateFlow<List<Movie>> = _searchResults

    private var _searchText by mutableStateOf("")

    private val apiKey = "bebac384012d121b0ae26d449e71b4c7"

    init {
        searchMovie()
    }

    fun searchMovie() {
        if (_searchText.isEmpty()) {
            viewModelScope.launch {
                try {
                    val response = movieRepository.getPopularMovies(apiKey)
                    if (response.isSuccessful) {
                        _searchResults.value = response.body()!!
                    }
                } catch (e: Exception) {
                }
            }
        }
        else {
            viewModelScope.launch {
                try {
                    val response = movieRepository.searchMovies(apiKey, _searchText)
                    if (response.isSuccessful) {
                        _searchResults.value = response.body()!!
                    }
                } catch (e: Exception) {
                }
            }
        }
    }

    fun updateSearchText(searchText: String) {
            _searchText = searchText
    }
}
