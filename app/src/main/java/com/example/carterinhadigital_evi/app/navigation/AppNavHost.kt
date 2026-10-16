package com.example.carterinhadigital_evi.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.carterinhadigital_evi.app.di.AppContainer
import com.example.carterinhadigital_evi.app.navigation.aluno.alunoNavGraph
import com.example.carterinhadigital_evi.app.navigation.auth.authNavGraph
import com.example.carterinhadigital_evi.app.navigation.professor.professorNavGraph
import com.example.carterinhadigital_evi.app.session.SessionViewModel
import com.example.carterinhadigital_evi.app.session.SessionViewModelFactory
import com.example.carterinhadigital_evi.feature.login.domain.model.PerfilAcesso

@Composable
fun AppNavHost(
    navController: NavHostController,
    darkTheme: Boolean,
    onDarkThemeChange: (Boolean) -> Unit,
    container: com.example.carterinhadigital_evi.app.di.AppContainer
) {

    val sessionFactory = remember(container.sessionTokenStore) {
        _root_ide_package_.com.example.carterinhadigital_evi.app.session.SessionViewModelFactory(
            sessionTokenStore = container.sessionTokenStore
        )
    }

    val sessionViewModel: com.example.carterinhadigital_evi.app.session.SessionViewModel = viewModel(
        factory = sessionFactory
    )

    fun graphFor(perfil: PerfilAcesso): String {
        return when (perfil) {
            PerfilAcesso.ALUNO -> _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.ALUNO
            PerfilAcesso.PROFESSOR -> _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.PROFESSOR
        }
    }

    fun replaceGraph(
        currentGraph: String,
        destinationGraph: String
    ) {

        navController.navigate(destinationGraph) {
            popUpTo(currentGraph) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }

    NavHost(
        navController = navController,
        startDestination = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.AUTH
    ) {
        authNavGraph(
            loginRepository = container.loginRepository,
            onLoginSucesso = { usuario ->
                sessionViewModel.setUsuarioLogado(usuario)
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.AUTH,
                    destinationGraph = graphFor(usuario.perfil)
                )
            }
        )

        alunoNavGraph(
            navController = navController,
            usuarioLogadoFlow = sessionViewModel.usuarioLogado,
            unidadeCurricularRepository = container.unidadeCurricularRepository,
            darkTheme = darkTheme,
            onDarkThemeChange = onDarkThemeChange,
            onLogout = {
                sessionViewModel.limparSessao()
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.ALUNO,
                    destinationGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.AUTH
                )
            },
            onSessaoAusente = {
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.ALUNO,
                    destinationGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.AUTH
                )
            },
            onPerfilInvalido = { perfil ->
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.ALUNO,
                    destinationGraph = graphFor(perfil)
                )
            }
        )

        professorNavGraph(
            usuarioLogadoFlow = sessionViewModel.usuarioLogado,
            darkTheme = darkTheme,
            onDarkThemeChange = onDarkThemeChange,
            onLogout = {
                sessionViewModel.limparSessao()
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.PROFESSOR,
                    destinationGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.AUTH
                )
            },
            onSessaoAusente = {
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.PROFESSOR,
                    destinationGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.AUTH
                )
            },
            onPerfilInvalido = { perfil ->
                replaceGraph(
                    currentGraph = _root_ide_package_.com.example.carterinhadigital_evi.app.navigation.GraphRoutes.PROFESSOR,
                    destinationGraph = graphFor(perfil)
                )
            }
        )
    }
}