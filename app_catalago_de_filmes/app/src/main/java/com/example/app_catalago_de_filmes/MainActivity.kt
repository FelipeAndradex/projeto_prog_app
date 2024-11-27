package com.example.app_catalago_de_filmes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_catalago_de_filmes.di.appModule
import com.example.app_catalago_de_filmes.ui.theme.App_catalago_de_filmesTheme
import com.example.app_catalago_de_filmes.ui.screens.MoviesScreen
import com.example.app_catalago_de_filmes.viewmodel.MovieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            startKoin{
                androidContext(this@MainActivity)
                modules(appModule)
            }
        setContent {
            App()
        }
    }

    @Composable
    fun App() {
        val viewModel: MovieViewModel = koinViewModel()
        App_catalago_de_filmesTheme {
            val navController = rememberNavController()
            Scaffold(modifier = Modifier.fillMaxSize()) { padding->
                NavHost(navController = navController, startDestination = Movies) {
                    composable<Movies> {
                        MoviesScreen(navController = navController, movieViewModel = viewModel)
                    }
                }
            }
        }
    }
}
