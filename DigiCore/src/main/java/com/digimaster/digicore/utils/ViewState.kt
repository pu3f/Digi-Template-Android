package com.digimaster.digicore.utils

data class ViewState<out T>(val status: ResponseStatus, val data: T?, val message: String?) {

    companion object {

        fun <T> success(data: T?): ViewState<T> {
            return ViewState(ResponseStatus.SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): ViewState<T> {
            return ViewState(ResponseStatus.ERROR, data, msg)
        }

        fun <T> loading(data: T?): ViewState<T> {
            return ViewState(ResponseStatus.LOADING, data, null)
        }

        fun <T> empty(msg: String): ViewState<T> {
            return  ViewState(ResponseStatus.EMPTY, null, msg)
        }
    }

}
