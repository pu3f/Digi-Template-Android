package com.digimaster.template.app

import android.app.Application
import io.easyprefs.Prefs

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Prefs.initializeApp(this)
    }
}