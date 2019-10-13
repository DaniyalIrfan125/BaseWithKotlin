package daniyal.android.basewithkotlin.schedulers


import androidx.annotation.NonNull
import io.reactivex.Scheduler

/****
 * Scheduler contract interface
 *****/
interface SchedulerContract {

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}