package com.projeto.ponto5.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.projeto.ponto5.viewmodel.ConfigViewModel

// -------------------- Composable --------------------
@Composable
fun ConfigScreen(viewModel: ConfigViewModel) {
    val context = LocalContext.current

    // Estados locais da UI
    var cpf by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    // Coleta eventos do ViewModel
    LaunchedEffect(viewModel) {
        viewModel.eventoResultado.collect { msg ->
            mensagem = msg
        }

        viewModel.obterUsuario(context).collect { (savedCpf, savedSenha) ->
            cpf = savedCpf ?: ""
            senha = savedSenha ?: ""
        }
    }

    // -------------------- Layout --------------------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.salvarUsuario(cpf, senha, context) }) {
            Text("Salvar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (mensagem.isNotEmpty()) {
            Text(mensagem)
        }
    }
}
