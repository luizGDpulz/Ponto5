import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // Event flow de mensagens para UI
    private val _eventoResultado = MutableSharedFlow<String>()
    val eventoResultado = _eventoResultado.asSharedFlow()

    fun salvarUsuario(cpf: String, senha: String, context: Context) {
        viewModelScope.launch {
            salvarCredenciais(context, cpf, senha)
            _eventoResultado.emit("Credenciais salvas!")
        }
    }

    fun obterUsuario(context: Context): Flow<Pair<String?, String?>> {
        return lerCredenciais(context)
    }
}
