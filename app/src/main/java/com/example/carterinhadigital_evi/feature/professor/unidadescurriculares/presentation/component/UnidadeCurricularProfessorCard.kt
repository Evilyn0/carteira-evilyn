package com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carterinhadigital_evi.feature.professor.unidadescurriculares.domain.model.UnidadeCurricularProfessor

@Composable
fun UnidadeCurricularProfessorCard(
    modifier: Modifier = Modifier,
    unidadeCurricular: UnidadeCurricularProfessor
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = unidadeCurricular.nome,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = "Turma: ${unidadeCurricular.turma}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Carga Horária: ${unidadeCurricular.cargaHoraria}h",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Aulas: ${unidadeCurricular.aulasRealizadas}/${unidadeCurricular.quantidadeAulas}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            val dias = unidadeCurricular.diasSemana.joinToString(", ")
            Text(
                text = "Dias: $dias",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = "Horário: ${unidadeCurricular.horarioInicio} - ${unidadeCurricular.horarioFim}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UnidadeCurricularProfessorCardPreview() {
    UnidadeCurricularProfessorCard(
        unidadeCurricular = UnidadeCurricularProfessor(
            id = 10,
            nome = "Programação para Dispositivos Móveis",
            turmaId = 1,
            turma = "2DEVEST-A",
            cargaHoraria = 75,
            quantidadeAulas = 100,
            aulasRealizadas = 40,
            diasSemana = listOf("SEGUNDA", "QUARTA"),
            horarioInicio = "19:00",
            horarioFim = "22:30"
        )
    )
}
