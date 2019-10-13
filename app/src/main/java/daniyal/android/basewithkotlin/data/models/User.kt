package daniyal.android.basewithkotlin.data.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username") var username: String,
    @SerializedName("password") var password: String,
    @SerializedName("fullname") var fullName: String,
    @SerializedName("token") var authToken: String
) {
    init {
        username = ""
        password = ""
        fullName = ""
        authToken = ""
    }
}