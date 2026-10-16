package com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.domain.repository

import com.example.carterinhadigital_evi.feature.aluno.unidadescurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listar():Result<List<UnidadeCurricular>>
}