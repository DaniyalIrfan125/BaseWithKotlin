package daniyal.android.basewithkotlin.di.modules

import android.app.Application
import androidx.room.Room
import daniyal.android.basewithkotlin.schedulers.SchedulerContract
import daniyal.android.basewithkotlin.schedulers.SchedulerProvider
import dagger.Module
import dagger.Provides
import daniyal.android.basewithkotlin.data.local.dao.UserDao
import daniyal.android.basewithkotlin.data.local.db.LocalDatabase
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
    fun provideMainRepository(api: ApiInterface, userDao: UserDao, scheduler: SchedulerContract): MainRepository {
        return MainRepository(api,userDao, scheduler)
    }

    @Provides
    @Singleton
    fun provideScheduler(): SchedulerContract {
        return SchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideLocalDatabase(application: Application): LocalDatabase {
        return Room.databaseBuilder(application, LocalDatabase::class.java, "local.db").fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideUserDao(localDatabase: LocalDatabase): UserDao {
        return localDatabase.userDao()
    }
}