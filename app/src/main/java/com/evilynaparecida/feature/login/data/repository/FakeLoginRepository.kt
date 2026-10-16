package com.evilynaparecida.feature.login.data.repository

import com.evilynaparecida.feature.login.domain.model.PerfilAcesso
import com.evilynaparecida.feature.login.domain.model.UsuarioLogado
import com.evilynaparecida.feature.login.domain.repository.LoginRepository
import kotlinx.coroutines.delay

class FakeAuthRepository : LoginRepository {

    override suspend fun login(
        login: String,
        senha: String
    ): Result<UsuarioLogado> {
        delay(1000)

        if (senha != "123") {
            return Result.failure(
                IllegalArgumentException("Login ou senha inválidos")
            )
        }

        return when {
            login.equals("aluno", ignoreCase = true) || login.equals("evilyn", ignoreCase = true) -> {
                Result.success(
                    UsuarioLogado(
                        id = "1",
                        nome = "Evilyn Aparecida",
                        matricula = "2026000001",
                        perfil = PerfilAcesso.ALUNO,
                        curso = "Desenvolvimento de Sistemas",
                        turma = "2DEVEST-A",
                        token = "token-fake-aluno"
                    )
                )
            }

            login.equals("professor", ignoreCase = true) || login.equals("ana", ignoreCase = true) -> {
                Result.success(
                    UsuarioLogado(
                        id = "2",
                        nome = "Ana Souza",
                        matricula = "PROF20260001",
                        perfil = PerfilAcesso.PROFESSOR,
                        curso = "Computação",
                        turma = "ADS",
                        token = "token-fake-professor"
                    )
                )
            }

            else -> {
                Result.failure(
                    IllegalArgumentException("Login ou senha inválidos")
                )
            }
        }
    }
}
