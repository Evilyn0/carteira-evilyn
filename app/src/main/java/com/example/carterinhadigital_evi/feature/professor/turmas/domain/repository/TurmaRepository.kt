package com.example.carterinhadigital_evi.feature.professor.turmas.domain.repository

import com.example.carterinhadigital_evi.feature.professor.turmas.domain.model.Turma

interface TurmaRepository {
    suspend fun listar(): Result<List<Turma>>
}
