package com.example.converterapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ConverterApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}