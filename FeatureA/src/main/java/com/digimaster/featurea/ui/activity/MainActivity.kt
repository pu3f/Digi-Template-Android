package com.digimaster.featurea.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.digimaster.digicore.AppNavigation
import com.digimaster.digicore.room.Notification
import com.digimaster.digicore.utils.ResponseStatus
import com.digimaster.featurea.databinding.ActivityMainBinding
import com.digimaster.featurea.ui.viewmodel.MainViewModel
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
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    /*
                        handle data if success here
                     */
                    it.data?.newsDataList?.let { newsList ->
                        for (news in newsList) {
                            Log.i("MainActivity", "News Title ${news.newsName}")
                        }
                    }
                }
                ResponseStatus.ERROR -> {
                    /*
                        handle error state here
                     */
                    Toast.makeText(applicationContext, "Error ${it.message}", Toast.LENGTH_SHORT)
                        .show()
                }
                ResponseStatus.EMPTY -> {
                    /*
                       handle empty state here
                    */
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                }
                ResponseStatus.LOADING -> {
                    Toast.makeText(applicationContext, "Loading", Toast.LENGTH_SHORT).show()
                    /*
                        show loading state/progress here
                     */
                }
            }
        })

        viewModel.getNotifications().observe(this, Observer {
            when (it.status) {
                ResponseStatus.SUCCESS -> {
                    it.data?.let {notifications ->
                        for(notification in notifications){
                            Log.i("MainActivity", "Notifications $notification")
                        }
                    }
                }
                ResponseStatus.ERROR -> {
                    /*
                        handle error state here
                     */
                    Toast.makeText(applicationContext, "Error ${it.message}", Toast.LENGTH_SHORT)
                        .show()
                }
                ResponseStatus.LOADING -> {
                    Toast.makeText(applicationContext, "Loading", Toast.LENGTH_SHORT).show()
                    /*
                        show loading state/progress here
                     */
                }
                ResponseStatus.EMPTY -> {
                    /*
                     handle empty state here
                    */
                    Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}