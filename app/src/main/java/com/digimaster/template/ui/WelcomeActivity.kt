package com.digimaster.template.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.digimaster.template.databinding.ActivitySplashScreenBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private val BASE_PACKAGE_FEATUREA = "com.digimaster.featurea"

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        splashScreen.setKeepOnScreenCondition{ true }

        openMainActivity(applicationContext)
    }

    private fun openMainActivity(context: Context) {
        val intent =
            Intent(context, Class.forName("$BASE_PACKAGE_FEATUREA.app.ui.activity.MainActivity"))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
        finish()
    }
}