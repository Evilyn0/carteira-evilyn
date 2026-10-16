package com.example.carterinhadigital_evi.app.di

import com.example.carterinhadigital_evi.core.auth.SessionTokenStore
import com.example.carterinhadigital_evi.core.network.NetworkClient
import com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.data.remote.service.UnidadeCurricularApi
import com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.data.repository.ApiUnidadeCurricularRepositoryImpl
import com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.example.carterinhadigital_evi.feature.login.data.remote.service.AuthApi
import com.example.carterinhadigital_evi.feature.login.data.repository.ApiLoginRepositoryImpl
import com.example.carterinhadigital_evi.feature.login.data.repository.FakeAuthRepository
import com.example.carterinhadigital_evi.feature.login.domain.repository.LoginRepository
import com.example.carterinhadigital_evi.feature.professor.turmas.data.remote.service.TurmaApi
import com.example.carterinhadigital_evi.feature.professor.turmas.data.repository.ApiTurmaRepositoryImpl
import com.example.carterinhadigital_evi.feature.professor.turmas.domain.repository.TurmaRepository
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.data.remote.service.UnidadeCurricularProfessorApi
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.data.repository.ApiUnidadeCurricularProfessorRepositoryImpl
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularProfessorRepository

class DefaultAppContainer : AppContainer {
    override val sessionTokenStore: SessionTokenStore = SessionTokenStore()
    private val networkClient = NetworkClient(
        baseUrl = BASE_URL,
        sessionTokenStore = sessionTokenStore
    )

    private val authApi: AuthApi by lazy {
        networkClient.createPublic(AuthApi::class.java)
    }

    private val unidadeCurricularApi: UnidadeCurricularApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularApi::class.java)
    }

    private val turmaApi: TurmaApi by lazy {
        networkClient.createAuthenticated(TurmaApi::class.java)
    }

    private val unidadeCurricularProfessorApi: UnidadeCurricularProfessorApi by lazy {
        networkClient.createAuthenticated(UnidadeCurricularProfessorApi::class.java)
    }

    override val loginRepository: LoginRepository by lazy {
        if (USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }

    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }

    override val turmaRepository: TurmaRepository by lazy {
        ApiTurmaRepositoryImpl(api = turmaApi)
    }

    override val unidadeCurricularProfessorRepository: UnidadeCurricularProfessorRepository by lazy {
        ApiUnidadeCurricularProfessorRepositoryImpl(api = unidadeCurricularProfessorApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}
