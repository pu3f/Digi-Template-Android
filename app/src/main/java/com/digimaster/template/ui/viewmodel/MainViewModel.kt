package com.digimaster.template.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.digimaster.template.data.di.DaggerMainComponent
import com.digimaster.template.data.repository.MainRepository
import com.digimaster.template.model.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {
    private val news = MutableLiveData<NewsResponse>()
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

    fun getNews(): MutableLiveData<NewsResponse> = news

    fun isError(): MutableLiveData<Boolean> = isError

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}