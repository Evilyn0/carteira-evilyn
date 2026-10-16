package com.example.carterinhadigital_evi.app.di

import com.example.carterinhadigital_evi.core.auth.SessionTokenStore
import com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.example.carterinhadigital_evi.feature.login.domain.repository.LoginRepository
import com.example.carterinhadigital_evi.feature.professor.turmas.domain.repository.TurmaRepository
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularProfessorRepository

interface AppContainer {
    val sessionTokenStore: SessionTokenStore
    val loginRepository: LoginRepository
    val unidadeCurricularRepository: UnidadeCurricularRepository
    val turmaRepository: TurmaRepository
    val unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository
}
