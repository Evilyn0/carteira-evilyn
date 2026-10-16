package com.example.carterinhadigital_evi.app.navigation.professor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.carterinhadigital_evi.app.navigation.GraphRoutes
import com.example.carterinhadigital_evi.app.navigation.ProfileGuard
import com.example.carterinhadigital_evi.app.ui.AppShell
import com.example.carterinhadigital_evi.feature.login.domain.model.PerfilAcesso
import com.example.carterinhadigital_evi.feature.login.domain.model.UsuarioLogado
import com.example.carterinhadigital_evi.feature.professor.home.presentation.screen.HomeProfessorScreen
import kotlinx.coroutines.flow.StateFlow

fun NavGraphBuilder.professorNavGraph(
    usuarioLogadoFlow: StateFlow<UsuarioLogado?>,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    onLogout: () -> Unit,
    onSessaoAusente: () -> Unit,
    onPerfilInvalido: (PerfilAcesso) -> Unit
) {
    navigation(startDestination = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.professor.ProfessorRoutes.HOME, route = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.PROFESSOR) {
        composable(route = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.professor.ProfessorRoutes.HOME) {
            _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.ProfileGuard(
                usuarioFlow = usuarioLogadoFlow,
                perfilEsperado = PerfilAcesso.PROFESSOR,
                onSessaoAusente = onSessaoAusente,
                onPerfilInvalido = onPerfilInvalido
            ) { usuario ->
                AppShell(
                    title = "Início",
                    usuarioLogado = usuario,
                    canNavigateBack = false,
                    darkTheme = darkTheme,
                    onDarkThemeChange = onDarkThemeChange,
                    onNavigateBack = {},
                    onLogout = onLogout
                ) { innerPadding ->
                    HomeProfessorScreen(
                        usuarioLogado = usuario,
                        onTurmasClick = {},
                        onUnidadesCurricularesClick = {},
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    )
                }
            }
        }
    }
}
