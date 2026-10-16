package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.model

data class UnidadeCurricularProfessor(
    val id: Int,
    val nome: String,
    val turmaId: Int,
    val turma: String,
    val cargaHoraria: Int,
    val quantidadeAulas: Int,
    val aulasRealizadas: Int,
    val diasSemana: List<String>,
    val horarioInicio: String,
    val horarioFim: String
)
