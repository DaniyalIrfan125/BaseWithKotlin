package daniyal.android.basewithkotlin.data.remote.response

import android.content.Context
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.stream.MalformedJsonException
import daniyal.android.basewithkotlin.BaseApplication
import daniyal.android.basewithkotlin.R
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Data model class which represents the API Response
 **/

data class ApiResponse<out T>(
    val status: Int,
    val data: T?,
    val error: Throwable?
) {

    var errorCode: String = ""
    var errorDescription: String = ""

    init {
        error?.let {
            val context: Context = BaseApplication.applicationContext()
            this.errorDescription = context.getString(R.string.unknownError)
            when (it) {
                is SocketTimeoutException -> {
                    this.errorDescription = context.getString(R.string.requestTimeOutError)
                    this.errorCode = context.getString(R.string.networkErrorCode)
                }
                is MalformedJsonException -> {
                    this.errorDescription = context.getString(R.string.responseMalformedJson)
                    this.errorCode = context.getString(R.string.errorCodeMalformedJson)
                }
                is IOException -> {
                    this.errorDescription = context.getString(R.string.networkError)
                    this.errorCode = context.getString(R.string.networkErrorCode)
                }

                is HttpException -> {
                    try {
                        val apiErrorResponse: ErrorResponse = Gson().fromJson(
                            it.response().errorBody()?.string(),
                            ErrorResponse::class.java
                        )
                        if (!TextUtils.isEmpty(apiErrorResponse.errorCode))
                            this.errorCode = apiErrorResponse.errorCode
                        if (!TextUtils.isEmpty(apiErrorResponse.errorDescription))
                            this.errorDescription = apiErrorResponse.errorDescription
                    } catch (ex: Exception) {
                        this.errorDescription = context.getString(R.string.unknownError)
                    }
                }
            }
        }
    }
}