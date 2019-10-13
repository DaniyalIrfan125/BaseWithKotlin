package daniyal.android.basewithkotlin.data.remote.repository

import com.google.gson.JsonObject
import daniyal.android.basewithkotlin.data.models.User
import daniyal.android.basewithkotlin.data.remote.ApiInterface
import daniyal.android.basewithkotlin.data.remote.response.ResponseListener
import daniyal.android.basewithkotlin.schedulers.SchedulerContract
import timber.log.Timber
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: ApiInterface, scheduler: SchedulerContract) :
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
    fun weatherReq(authorizationHeader: String, bodyParams: JsonObject, responseListener: ResponseListener<User>) {
        performRequest(api.login(authorizationHeader, bodyParams), responseListener)
    }
}