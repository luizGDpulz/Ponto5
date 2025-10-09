package com.projeto.ponto5.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.projeto.ponto5.ui.theme.White
import com.projeto.ponto5.viewmodel.MainViewModel

@Composable
fun MainScreen(viewModel: MainViewModel) {
    //val viewModel: MainViewModel = viewModel()

    val cpf by viewModel.cpf.collectAsState()
    var resultado by remember { mutableStateOf("") }

    LaunchedEffect(viewModel) {
        viewModel.login()
        viewModel.eventoResultado.collect { msg ->
            resultado = msg
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cpf,
            onValueChange = { viewModel.atualizarCpf(it) },
            label = { Text("CPF") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.incluirPonto(
                latitude = -29.656351437469443,
                longitude = -51.051604049630456,
                precisao = 10.0
            )
        }) {
            Text("Incluir Ponto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (resultado.isNotEmpty()) {
            Text(resultado, style = MaterialTheme.typography.bodyLarge, color = White)
        }
    }
}