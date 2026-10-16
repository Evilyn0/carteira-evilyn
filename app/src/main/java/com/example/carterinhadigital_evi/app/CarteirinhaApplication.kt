package com.example.carterinhadigital_evi.app

import android.app.Application
import com.example.carterinhadigital_evi.app.di.AppContainer
import com.example.carterinhadigital_evi.app.di.DefaultAppContainer

class CarteirinhaApplication : android.app.Application() {
    val container: com.example.carterinhadigital_evi.app.di.AppContainer by lazy {
        _root_ide_package_.com.example.carterinhadigital_evi.app.di.DefaultAppContainer()
    }
}