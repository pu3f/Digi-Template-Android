package com.digimaster.featurea.app.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digimaster.digicore.utils.ViewState
import com.digimaster.featurea.domain.models.NewsModel
import com.digimaster.featurea.domain.models.NotificationModel
import com.digimaster.featurea.domain.usecases.GetNewsUseCase
import com.digimaster.featurea.domain.usecases.GetNotificationUseCase
import com.digimaster.featurea.domain.usecases.SaveNotificationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,
    private val getNotificationUseCase: GetNotificationUseCase,
    private val saveNotificationUseCase: SaveNotificationUseCase
) : ViewModel() {
    private val news = MutableLiveData<ViewState<NewsModel>>()
    private val notifications = MutableLiveData<ViewState<List<NotificationModel>>>()
    private val compositeDisposable = CompositeDisposable()

    fun loadNews() {
        news.value = ViewState.loading(null)

        compositeDisposable.add(
            getNewsUseCase.execute().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<NewsModel>() {
                    override fun onSuccess(t: NewsModel) {
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

    fun loadNotifications() {
        compositeDisposable.add(
            getNotificationUseCase.execute()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<NotificationModel>>() {
                    override fun onNext(t: List<NotificationModel>) {
                        if (t.isNotEmpty()) {
                            notifications.value = ViewState.success(t)
                        } else {
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

    fun insertNotification(notification: NotificationModel) {
        compositeDisposable.add(
            saveNotificationUseCase.save(notification)
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

    fun getNotifications(): MutableLiveData<ViewState<List<NotificationModel>>> = notifications

    fun getNews(): MutableLiveData<ViewState<NewsModel>> = news

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}