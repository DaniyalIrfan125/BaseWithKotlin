package daniyal.android.basewithkotlin.data.remote.response


import com.google.gson.annotations.SerializedName

/****
 * Data Model class which represents the error response
 * Modified on: 4/3/19
 *****/
data class ErrorResponse (@SerializedName("errorCode") var errorCode:  String,
                          @SerializedName("errorDescription") var errorDescription: String){
    init {
        errorCode = ""
        errorDescription = ""
    }
}