package daniyal.android.basewithkotlin.di


import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import daniyal.android.basewithkotlin.BaseApplication
import daniyal.android.basewithkotlin.di.modules.ActivityBuilderModule
import daniyal.android.basewithkotlin.di.modules.AppModule
import daniyal.android.basewithkotlin.di.modules.NetworkModule
import javax.inject.Singleton

/**
 * App component interface of Dagger 2
 */

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class, ActivityBuilderModule::class, AndroidInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(baseApplication: BaseApplication)
}