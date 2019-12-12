package daniyal.android.basewithkotlin.data.preferences

import android.content.Context
import android.content.SharedPreferences
import daniyal.android.basewithkotlin.utils.AppConstants


/**
 * Shared Preference Provider Class
 */
class SharedPreferenceProvider(context: Context) {

    private val appContext = context.applicationContext
    private val sharedPreference :SharedPreferences
    get()= appContext.getSharedPreferences(AppConstants.SHAREDPREFERENCENAME,0)


    fun insertData (item :String){

        sharedPreference.edit().putString(AppConstants.keyInsertData,item).apply()
    }

    fun getData ():String?{

        return sharedPreference.getString(AppConstants.keyInsertData,null)
    }

}