package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.presentation

import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.model.UnidadeCurricularProfessor

data class UnidadeCurricularProfessorUiState(
    val isLoading: Boolean = false,
    val unidades: List<UnidadeCurricularProfessor> = emptyList(),
    val errorMessage: String? = null
)
