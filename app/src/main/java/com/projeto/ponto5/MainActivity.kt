package com.projeto.ponto5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.projeto.ponto5.ui.screens.*
import com.projeto.ponto5.ui.theme.Ponto5Theme
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.projeto.ponto5.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ponto5Theme {
                val mainViewModel: MainViewModel = viewModel()
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "config") {
                    //composable("main") { Tela1Screen(navController) }
                    composable("config") { Tela2Screen(viewModel = mainViewModel, navController = navController) }
                    composable(
                        route = "main/{cpf}",
                        arguments = listOf(navArgument("cpf") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val cpf = backStackEntry.arguments?.getString("cpf")
                        Tela1Screen(viewModel = mainViewModel, navController = navController, cpf = cpf)
                    }
                }

                // val mainViewModel: MainViewModel = viewModel()
                // MainScreen(viewModel = mainViewModel)
            }
        }
    }
}