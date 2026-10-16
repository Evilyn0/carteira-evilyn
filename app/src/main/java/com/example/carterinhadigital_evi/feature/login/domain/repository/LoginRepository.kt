package com.example.carterinhadigital_evi.feature.login.domain.repository

import com.example.carterinhadigital_evi.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login(login: String, senha: String): Result<UsuarioLogado>
}