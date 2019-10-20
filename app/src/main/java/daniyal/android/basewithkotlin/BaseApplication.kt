package daniyal.android.basewithkotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import daniyal.android.basewithkotlin.di.AppInjector
import javax.inject.Inject

class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    init {
        instance = this
    }

    companion object {
        private var instance: BaseApplication? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        AppInjector.init(this)

        Stetho.initializeWithDefaults(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}