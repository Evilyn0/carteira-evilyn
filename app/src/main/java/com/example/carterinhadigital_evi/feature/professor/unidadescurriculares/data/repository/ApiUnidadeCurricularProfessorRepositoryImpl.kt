package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.data.repository

import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.data.remote.service.UnidadeCurricularProfessorApi
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.model.UnidadeCurricularProfessor
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularProfessorRepository
import retrofit2.HttpException
import java.io.IOException

class ApiUnidadeCurricularProfessorRepositoryImpl(
    private val api: UnidadeCurricularProfessorApi
) : UnidadeCurricularProfessorRepository {

    override suspend fun listar(): Result<List<UnidadeCurricularProfessor>> {
        return runCatching {
            api.listar().map { it.toDomain() }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()}).")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares.")
            }
        }
    }
}
