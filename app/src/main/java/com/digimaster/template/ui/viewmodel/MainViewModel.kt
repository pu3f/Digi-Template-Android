package com.digimaster.template.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digimaster.digicore.room.Notification
import com.digimaster.digicore.utils.ViewState
import com.digimaster.template.data.repository.MainRepository
import com.digimaster.template.model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {
    private val news = MutableLiveData<ViewState<NewsResponse>>()
    private val notifications = MutableLiveData<ViewState<List<Notification>>>()
    private val compositeDisposable = CompositeDisposable()

    fun loadNews(){
        news.value = ViewState.loading(null)

        compositeDisposable.add(
            mainRepository.getNews().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsResponse>(){
                    override fun onSuccess(t: NewsResponse) {
                        if (t.code == 200) {
                            news.value = ViewState.success(t)
                        } else {
                            news.value = ViewState.error(t.status, null)
                        }
                    }

                    override fun onError(e: Throwable) {
                        news.value = ViewState.error("${e.message}", null)
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
                    override fun onNext(t: List<Notification>) {
                        if(t.isNotEmpty()){
                            notifications.value = ViewState.success(t)
                        }else{
                            notifications.value = ViewState.empty("no data")
                        }
                    }

                    override fun onError(t: Throwable?) {
                        notifications.value = ViewState.error("$t", null)
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

    fun getNotifications(): MutableLiveData<ViewState<List<Notification>>> = notifications

    fun getNews(): MutableLiveData<ViewState<NewsResponse>> = news

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}