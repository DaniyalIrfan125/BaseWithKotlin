package daniyal.android.basewithkotlin.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils {

     fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }


}