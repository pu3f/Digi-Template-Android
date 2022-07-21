package com.digimaster.featurea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digimaster.featurea.databinding.ActivityFeatureAactivityBinding

class FeatureAActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeatureAactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureAactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}