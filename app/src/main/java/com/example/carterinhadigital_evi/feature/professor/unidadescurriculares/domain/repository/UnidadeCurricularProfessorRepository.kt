package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.repository

import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.model.UnidadeCurricularProfessor

interface UnidadeCurricularProfessorRepository {
    suspend fun listar(): Result<List<UnidadeCurricularProfessor>>
}
