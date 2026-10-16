package com.example.carterinhadigital_evi.app.di

import com.example.carterinhadigital_evi.core.auth.SessionTokenStore
import com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.example.carterinhadigital_evi.feature.login.domain.repository.LoginRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: UnidadeCurricularRepository
}
