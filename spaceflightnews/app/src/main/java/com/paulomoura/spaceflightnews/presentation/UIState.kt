package com.paulomoura.spaceflightnews.presentation

sealed class UIState<T>(val data: T? = null, val throwable: Throwable? = null) {
    class Loading<T> : UIState<T>()
    data class Success<T>(val successData: T) : UIState<T>(data = successData)
    data class Error<T>(val errorThrowable: Throwable? = null) : UIState<T>(throwable = errorThrowable)
}