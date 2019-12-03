package daniyal.android.basewithkotlin.data.preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceProvider(context: Context) {

    private val appContext = context.applicationContext
    private val sharedPreference :SharedPreferences
    get()= appContext.getSharedPreferences("MyAppPreferences",0)


    fun insertData (item :String){

        sharedPreference.edit().putString("mykey",item).apply()
    }

    fun getData ():String?{

        return sharedPreference.getString("mykey",null)
    }

}