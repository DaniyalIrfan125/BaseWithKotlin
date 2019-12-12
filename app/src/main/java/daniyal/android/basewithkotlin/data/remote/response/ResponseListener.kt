package daniyal.android.basewithkotlin.data.remote.response


/**
 * ResponseListener callback which is responsible for giving the API response back to the presentation layer
 **/
interface ResponseListener<T> {
    fun onStart()
    fun onFinish()
    fun onResponse(result: ApiResponse<T>)
}