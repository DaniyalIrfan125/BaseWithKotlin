package daniyal.android.basewithkotlin.data.remote.repository

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import daniyal.android.basewithkotlin.data.local.dao.UserDao
import daniyal.android.basewithkotlin.data.local.entity.UserEntity
import daniyal.android.basewithkotlin.data.models.User
import daniyal.android.basewithkotlin.data.remote.ApiInterface
import daniyal.android.basewithkotlin.data.remote.response.ResponseListener
import daniyal.android.basewithkotlin.schedulers.SchedulerContract
import timber.log.Timber
import javax.inject.Inject
import android.os.AsyncTask
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainRepository @Inject constructor(private val api: ApiInterface, private val userDao: UserDao, scheduler: SchedulerContract) :
        BaseRepository(scheduler) {


    fun login() {

        Timber.d("login called")
    }

    /**
     * The method for performing the user login
     * @param authorizationHeader : Access Token
     * @param bodyParams: Json Body
     * @param responseListener: Response Listener Callback
     */
    fun login(authorizationHeader: String, bodyParams: JsonObject, responseListener: ResponseListener<User>) {
        performRequest(api.login(authorizationHeader, bodyParams), responseListener)
    }



    fun addUser(userEntity: UserEntity){
       // insertAsyncTask(userDao).execute(userEntity)
        userDao.saveUser(userEntity)

    }

   fun showData(): LiveData<List<UserEntity>>{

        return userDao.loadUsersList()

    }


    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: UserDao) : AsyncTask<UserEntity, Void, Void>() {

        override fun doInBackground(vararg params: UserEntity): Void? {
            mAsyncTaskDao.saveUser(params[0])
            return null
        }
    }
}