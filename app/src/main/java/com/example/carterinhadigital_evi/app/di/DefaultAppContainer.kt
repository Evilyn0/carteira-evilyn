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

class DefaultAppContainer : com.example.carterinhadigital_evi.app.di.AppContainer {
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

    override val loginRepository: LoginRepository by lazy {
        if (_root_ide_package_.com.example.carterinhadigital_evi.app.di.DefaultAppContainer.Companion.USE_FAKE_LOGIN_REPOSITORY) {
            FakeAuthRepository()
        } else {
            ApiLoginRepositoryImpl(api = authApi)
        }
    }
    override val unidadeCurricularRepository: UnidadeCurricularRepository by lazy {
        ApiUnidadeCurricularRepositoryImpl(api = unidadeCurricularApi)
    }

    companion object {
        private const val BASE_URL = "http://10.0.2.2:8080/"
        private const val USE_FAKE_LOGIN_REPOSITORY = false
    }
}