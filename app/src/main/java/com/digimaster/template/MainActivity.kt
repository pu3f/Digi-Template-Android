package com.digimaster.template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digimaster.digicore.AppNavigation
import com.digimaster.digicore.pref.PrefUtils
import com.digimaster.template.databinding.ActivityMainBinding
import io.easyprefs.Prefs

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFeatureA.setOnClickListener {
            AppNavigation.openFeatureAActivity(this)
        }

        binding.btnFeatureB.setOnClickListener {
            AppNavigation.openFeatureBActivity(this)
        }
    }
}