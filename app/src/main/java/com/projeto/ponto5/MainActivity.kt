package com.projeto.ponto5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.projeto.ponto5.ui.screens.ConfigScreen
import com.projeto.ponto5.ui.theme.Ponto5Theme
import com.projeto.ponto5.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ponto5Theme {
                val mainViewModel: MainViewModel = viewModel()
                // Chamando a tela principal (Composable)
                ConfigScreen(viewModel = mainViewModel)
            }
        }
    }
}