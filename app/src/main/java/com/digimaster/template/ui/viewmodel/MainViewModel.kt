package com.digimaster.template.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digimaster.digicore.room.Notification
import com.digimaster.template.data.repository.MainRepository
import com.digimaster.template.model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {
    private val news = MutableLiveData<NewsResponse>()
    private val notifications = MutableLiveData<List<Notification>>()
    private val compositeDisposable = CompositeDisposable()
    private val isError = MutableLiveData<Boolean>()

    fun loadNews(){
        compositeDisposable.add(
            mainRepository.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsResponse>(){
                    override fun onSuccess(t: NewsResponse) {
                        if (t.code == 200) {
                            isError.value = false
                            news.value = t
                        } else {
                            isError.value = true
                        }
                    }

                    override fun onError(e: Throwable) {
                        isError.value = true
                    }

                }
        ))
    }

    fun loadNotifications(){
        compositeDisposable.add(
            mainRepository.loadNotification()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<Notification>>(){
                    override fun onNext(t: List<Notification>?) {
                        Log.i("MainViewModel", "onNext $t")
                        t.let {
                            notifications.value = it
                        }
                    }

                    override fun onError(t: Throwable?) {
                        t?.printStackTrace()
                        Log.i("MainViewModel", "Error $t")
                    }

                    override fun onComplete() {
                    }

                })

        )
    }

    fun insertNotification(notification: Notification){
        compositeDisposable.add(
            mainRepository.insertNotification(notification)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Long>(){
                    override fun onSuccess(t: Long) {
                        Log.i("MainViewModel", "Success insert notification $t")
                    }

                    override fun onError(e: Throwable) {
                        Log.e("MainViewModel", "Error insert notification $e")
                    }

                })
        )
    }

    fun getNotifications(): MutableLiveData<List<Notification>> = notifications

    fun getNews(): MutableLiveData<NewsResponse> = news

    fun isError(): MutableLiveData<Boolean> = isError

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}