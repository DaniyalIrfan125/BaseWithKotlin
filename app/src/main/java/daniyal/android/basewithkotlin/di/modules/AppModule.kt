package daniyal.android.basewithkotlin.di.modules

import daniyal.android.basewithkotlin.schedulers.SchedulerContract
import daniyal.android.basewithkotlin.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import daniyal.android.basewithkotlin.data.remote.ApiInterface
import daniyal.android.basewithkotlin.data.remote.repository.MainRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class AppModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


    @Provides
    @Singleton
    fun provideMainRepository(api: ApiInterface, scheduler: SchedulerContract): MainRepository {
        return MainRepository(api, scheduler)
    }

    @Provides
    @Singleton
    fun provideScheduler(): SchedulerContract {
        return SchedulerProvider()
    }
}