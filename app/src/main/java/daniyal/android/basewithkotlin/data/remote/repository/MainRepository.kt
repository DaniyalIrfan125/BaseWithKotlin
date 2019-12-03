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
import daniyal.android.basewithkotlin.data.models.CoinMarketPojo
import daniyal.android.basewithkotlin.data.models.EmployePojo
import daniyal.android.basewithkotlin.data.models.ToDoPojo
import daniyal.android.basewithkotlin.data.preferences.SharedPreferenceProvider


class MainRepository @Inject constructor(private val api: ApiInterface, private val userDao: UserDao, scheduler: SchedulerContract, private val sharedPreferenceProvider: SharedPreferenceProvider) :
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

    /**
     * The method for performing the user login
     * @param authorizationHeader : Access Token
     * @param bodyParams: Json Body
     * @param responseListener: Response Listener Callback
     */
    fun getEmployeDetails(responseListener: ResponseListener<List<EmployePojo>>) {
        performRequest(api.getEmployee(), responseListener)
    }

    /**
     * The method for performing the user login
     * @param authorizationHeader : Access Token
     * @param bodyParams: Json Body
     * @param responseListener: Response Listener Callback
     */
    fun getToDo(responseListener: ResponseListener<ToDoPojo>) {
        performRequest(api.getToDo(), responseListener)
    }


    /**
     * The method for performing the user login
     * @param authorizationHeader : Access Token
     * @param bodyParams: Json Body
     * @param responseListener: Response Listener Callback
     */
    fun getCoinMarketDetails(apiKey: String, start: String, limit: String, responseListener: ResponseListener<CoinMarketPojo>) {
        performRequest(api.getCoinMarketDetails(apiKey, start, limit), responseListener)
    }


    fun addUser(userEntity: UserEntity) {
        // insertAsyncTask(userDao).execute(userEntity)
        userDao.saveUser(userEntity)

    }

    fun showData(): LiveData<List<UserEntity>> {

        return userDao.loadUsersList()

    }


fun insertDataToSharedPreference(item :String){
    sharedPreferenceProvider.insertData(item)
}
    fun getDataFromSharedPreference():String?{
        return sharedPreferenceProvider.getData()
    }
}