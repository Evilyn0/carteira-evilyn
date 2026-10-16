package com.example.carterinhadigital_evi.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController

import com.example.carterinhadigital_evi.app.navigation.AppNavHost
import com.example.carterinhadigital_evi.core.designsystem.theme.CarteirinhaDigital2DEVESTTheme

@Composable
fun App(container: com.example.carterinhadigital_evi.app.di.AppContainer) {

    val systemDarkTheme = isSystemInDarkTheme()
    var darkTheme by rememberSaveable { mutableStateOf(systemDarkTheme) }

    CarteirinhaDigital2DEVESTTheme(
        darkTheme = darkTheme
    ) {
        val navController = rememberNavController()

        AppNavHost(
            navController = navController,
            darkTheme = darkTheme,
            onDarkThemeChange = { darkTheme = it },
            container = container
        )

    }
}