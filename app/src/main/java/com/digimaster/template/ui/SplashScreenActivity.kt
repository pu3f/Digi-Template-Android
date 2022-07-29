package com.digimaster.template.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.digimaster.template.R
import com.digimaster.template.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private val BASE_PACKAGE_FEATUREA = "com.digimaster.featurea"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Handler().postDelayed({
            openMainActivity(applicationContext)
        }, 1500)
    }

    private fun openMainActivity(context: Context) {
        val intent =
            Intent(context, Class.forName("$BASE_PACKAGE_FEATUREA.ui.activity.MainActivity"))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
        finish()
    }
}