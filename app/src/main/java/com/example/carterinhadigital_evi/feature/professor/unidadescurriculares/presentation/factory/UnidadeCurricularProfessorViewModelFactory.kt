package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularProfessorRepository
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.presentation.UnidadeCurricularProfessorViewModel

class UnidadeCurricularProfessorViewModelFactory(
    private val repository: UnidadeCurricularProfessorRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnidadeCurricularProfessorViewModel::class.java)) {
            return UnidadeCurricularProfessorViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel desconhecido")
    }
}
