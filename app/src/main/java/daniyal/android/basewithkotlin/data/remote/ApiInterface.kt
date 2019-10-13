package daniyal.android.basewithkotlin.data.remote

import com.google.gson.JsonObject
import daniyal.android.basewithkotlin.data.models.User
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @POST("user/login")
    fun login(@Header("Authorization") authorization: String, @Body params: JsonObject): Observable<User>

}