package com.example.carterinhadigital_evi.app.session

import androidx.lifecycle.ViewModel
import com.example.carterinhadigital_evi.core.auth.SessionTokenStore
import com.example.carterinhadigital_evi.feature.login.domain.model.UsuarioLogado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SessionViewModel(
    private val sessionTokenStore:SessionTokenStore
) : ViewModel() {
    private val _usuarioLogado =MutableStateFlow<UsuarioLogado?>(null)
    val usuarioLogado : StateFlow<UsuarioLogado?> = _usuarioLogado.asStateFlow()
    fun setUsuarioLogado(usuario: UsuarioLogado) {
        sessionTokenStore.salvar(usuario.token)
        _usuarioLogado.value = usuario
    }

    fun limparSessao() {
        sessionTokenStore.limpar()
        _usuarioLogado.value = null
    }
}