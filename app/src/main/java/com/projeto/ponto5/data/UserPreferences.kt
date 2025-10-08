import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Criando DataStore
val Context.dataStore by preferencesDataStore("user_prefs")

// Chaves das preferências
val CPF_KEY = stringPreferencesKey("cpf")
val PASSWORD_KEY = stringPreferencesKey("password")

// Função para salvar dados
suspend fun salvarCredenciais(context: Context, cpf: String, senha: String) {
    context.dataStore.edit { prefs ->
        prefs[CPF_KEY] = cpf
        prefs[PASSWORD_KEY] = senha
    }
}

// Função para ler dados
fun lerCredenciais(context: Context): Flow<Pair<String?, String?>> {
    return context.dataStore.data.map { prefs ->
        val cpf = prefs[CPF_KEY]
        val senha = prefs[PASSWORD_KEY]
        cpf to senha
    }
}