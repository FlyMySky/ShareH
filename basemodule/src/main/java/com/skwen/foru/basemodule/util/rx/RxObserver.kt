package com.skwen.foru.basemodule.util.rx

import io.reactivex.disposables.Disposable

abstract class RxObserver<T> {

    fun onSubscribe(d: Disposable) {

    }

    fun onError(e: Throwable) {

    }

    fun onComplete() {

    }

    abstract fun onReceived(t: T)
}