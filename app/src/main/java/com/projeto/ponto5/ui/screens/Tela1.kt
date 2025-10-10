package com.projeto.ponto5.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.projeto.ponto5.ui.theme.White
import com.projeto.ponto5.viewmodel.MainViewModel

@Composable
fun Tela1Screen(viewModel: MainViewModel, navController: NavHostController, cpf: String?) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main", style = MaterialTheme.typography.bodyLarge, color = White)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("config"){
                popUpTo("main/{cpf}") { inclusive = true }
                launchSingleTop = true
            }
        }) {
            Text("Configurações")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "$cpf", style = MaterialTheme.typography.bodyLarge, color = White)
    }

}