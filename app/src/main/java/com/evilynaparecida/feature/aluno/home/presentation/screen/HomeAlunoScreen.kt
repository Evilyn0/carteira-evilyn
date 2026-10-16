package com.evilynaparecida.feature.aluno.home.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.evilynaparecida.core.designsystem.component.NavigationButton
import com.evilynaparecida.core.designsystem.theme.DarkBackground
import com.evilynaparecida.core.designsystem.theme.DarkCardBorder
import com.evilynaparecida.core.designsystem.theme.EvilynAparecidaTheme
import com.evilynaparecida.core.designsystem.theme.RedAccent
import com.evilynaparecida.feature.login.domain.model.PerfilAcesso
import com.evilynaparecida.feature.login.domain.model.UsuarioLogado

@Composable
fun HomeAlunoScreen(
    usuarioLogado: UsuarioLogado,
    onCarteirinhaClick: () -> Unit,
    onUnidadesCurricularesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá, ${usuarioLogado.nome.ifBlank { "Evilyn Aparecida" }}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.5.dp, DarkCardBorder),
            colors = CardDefaults.cardColors(
                containerColor = DarkBackground
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = usuarioLogado.curso.ifBlank { "Desenvolvimento de Sistemas" },
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = RedAccent
                )

                Text(
                    text = "Turma: ${usuarioLogado.turma.ifBlank { "2DEVEST-A" }}",
                    color = Color.White
                )

                Text(
                    text = "Matrícula: ${usuarioLogado.matricula.ifBlank { "2026000001" }}",
                    color = Color.White
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NavigationButton(
                text = "Carteirinha Digital",
                onClick = onCarteirinhaClick,
                modifier = Modifier.fillMaxWidth()
            )

            NavigationButton(
                text = "Unidades Curriculares",
                onClick = onUnidadesCurricularesClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeAlunoScreenPreview() {
    EvilynAparecidaTheme {
        HomeAlunoScreen(
            usuarioLogado = UsuarioLogado(
                id = "1",
                nome = "Evilyn Aparecida",
                matricula = "2026000001",
                perfil = PerfilAcesso.ALUNO,
                curso = "Desenvolvimento de Sistemas",
                turma = "2DEVEST-A",
                token = "token"
            ),
            onCarteirinhaClick = {},
            onUnidadesCurricularesClick = {}
        )
    }
}
