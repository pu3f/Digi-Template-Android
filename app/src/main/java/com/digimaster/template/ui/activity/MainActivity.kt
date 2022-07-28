package com.digimaster.template.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.digimaster.digicore.AppNavigation
import com.digimaster.digicore.room.Notification
import com.digimaster.template.databinding.ActivityMainBinding
import com.digimaster.template.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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

        binding.btnInsertNotification.setOnClickListener {
            val notification = Notification(title = "Title A", content = "Content A")
            viewModel.insertNotification(notification)
        }

        binding.btnLoadNotification.setOnClickListener {
            viewModel.loadNotifications()
        }

        setObserver()
    }

    private fun setObserver() {
        viewModel.getNews().observe(this, Observer {
            with(it.newsDataList) {
                if (this.isNotEmpty()) {
                    for (news in this) {
                        Log.i("MainActivity", "News title ${news.newsName}")
                    }
                }
            }
        })

        viewModel.getNotifications().observe(this, Observer {
            with(it){
                for(notification in this){
                    Log.i("Main Activity", "Notification title ${notification.title}")
                }
            }
        })
    }
}