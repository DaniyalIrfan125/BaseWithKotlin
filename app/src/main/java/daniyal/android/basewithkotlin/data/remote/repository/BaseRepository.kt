package daniyal.android.basewithkotlin.data.remote.repository


import daniyal.android.basewithkotlin.schedulers.SchedulerContract
import daniyal.android.basewithkotlin.data.remote.response.ApiResponse
import daniyal.android.basewithkotlin.data.remote.response.ResponseListener
import daniyal.android.basewithkotlin.data.remote.response.ResponseStatus
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/****
 * Base repository which is responsible for executing all the REST service calls
 *****/
open class BaseRepository(val scheduler: SchedulerContract) {


    /**
     * This method perfroms the asynchronous network request using the scheduler
     * @param observable : Observable network request
     * @param responseListener: ResponseListener Callback
     */
    fun <T : Any> performRequest(
        observable: Observable<T>,
        responseListener: ResponseListener<T>
    ): Disposable {
        return observable.subscribeOn(scheduler.io())
            .observeOn(scheduler.ui())
            .doOnSubscribe { responseListener.onStart() }
            .doAfterTerminate { responseListener.onFinish() }
            .subscribe({ result: T ->
                responseListener.onResponse(
                    ApiResponse(
                        ResponseStatus.SUCCESS,
                        result,
                        null
                    )
                )
            },
                { error: Throwable? ->
                    responseListener.onResponse(
                        ApiResponse(
                            ResponseStatus.FAILURE,
                            null,
                            error
                        )
                    )
                })

    }

}