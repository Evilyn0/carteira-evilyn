package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.data.remote.service

import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.data.remote.dto.UnidadeCurricularProfessorDto
import retrofit2.http.GET

interface UnidadeCurricularProfessorApi {
    @GET("professores/me/unidades-curriculares")
    suspend fun listar(): List<UnidadeCurricularProfessorDto>
}
