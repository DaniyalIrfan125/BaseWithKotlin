package daniyal.android.basewithkotlin.data.remote

import com.google.gson.JsonObject
import daniyal.android.basewithkotlin.data.models.CoinMarketPojo
import daniyal.android.basewithkotlin.data.models.EmployePojo
import daniyal.android.basewithkotlin.data.models.ToDoPojo
import daniyal.android.basewithkotlin.data.models.User
import io.reactivex.Observable
import retrofit2.http.*

interface ApiInterface {

    @POST("user/login")
    fun login(@Header("Authorization") authorization: String, @Body params: JsonObject): Observable<User>

    @GET("/employees")
    fun getEmployee(): Observable<List<EmployePojo>>

    @GET("todos/1")
    fun getToDo(): Observable<ToDoPojo>

    @GET("cryptocurrency/listings/latest")
    fun getCoinMarketDetails(@Header("X-CMC_PRO_API_KEY") apiKey :String, @Query("start") start :String,
                             @Query("limit")limit :String): Observable<CoinMarketPojo>

}