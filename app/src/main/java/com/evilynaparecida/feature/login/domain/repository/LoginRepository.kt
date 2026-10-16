package com.evilynaparecida.feature.login.domain.repository

import com.evilynaparecida.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}
