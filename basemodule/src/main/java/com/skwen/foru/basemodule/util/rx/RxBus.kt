package com.skwen.foru.basemodule.util.rx

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

open class RxBus private constructor() {

    private var bus: Subject<Any>? = null

    init {
        bus = PublishSubject.create<Any>().toSerialized()
    }

    private object Holder {
        val instance = RxBus()
    }

    companion object {
        fun getInstance(): RxBus {
            return Holder.instance
        }
    }

    fun post(any: Any) {
        bus?.onNext(any)
    }

    fun <T> subscribe(clazz: Class<T>, rxObserver: RxObserver<T>) {
        bus?.ofType(clazz)?.subscribe(object : Observer<T> {
            override fun onComplete() {
                rxObserver.onComplete()
            }

            override fun onSubscribe(d: Disposable) {
                rxObserver.onSubscribe(d)
            }

            override fun onNext(t: T) {
                rxObserver.onReceived(t)
            }

            override fun onError(e: Throwable) {
                rxObserver.onError(e)
            }
        })
    }

    fun <T> subscribe(clazz: Class<T>): Observable<T> {
        return bus?.ofType(clazz)!!
    }


}