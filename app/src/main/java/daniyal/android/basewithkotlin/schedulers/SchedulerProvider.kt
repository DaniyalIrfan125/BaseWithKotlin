package daniyal.android.basewithkotlin.schedulers

import daniyal.android.basewithkotlin.schedulers.SchedulerContract
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/****
 * Android Scheduler provider for executing the asynchronous operations
 *****/
class SchedulerProvider : SchedulerContract {

    override fun io(): Scheduler {
        return Schedulers.newThread()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

}