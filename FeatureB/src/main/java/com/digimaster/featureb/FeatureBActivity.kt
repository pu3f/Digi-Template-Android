package com.digimaster.featureb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digimaster.featureb.databinding.ActivityFeatureBactivityBinding

class FeatureBActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFeatureBactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeatureBactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}