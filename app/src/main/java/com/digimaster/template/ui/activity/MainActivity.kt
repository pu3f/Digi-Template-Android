package com.digimaster.template.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.digimaster.digicore.AppNavigation
import com.digimaster.template.databinding.ActivityMainBinding
import com.digimaster.template.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

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

        binding.btnNews.setOnClickListener {
            viewModel.loadNews()
        }

        setObserver()
    }

    private fun setObserver() {
        viewModel.getNews().observe(this) {
            with (it.newsDataList) {
                if(this.isNotEmpty()){
                    for(news in this){
                        Log.i("MainActivity", "News title ${news.newsName}")
                    }
                }
            }
        }
    }
}