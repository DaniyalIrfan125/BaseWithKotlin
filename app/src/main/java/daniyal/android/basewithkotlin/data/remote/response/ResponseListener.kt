package daniyal.android.basewithkotlin.data.remote.response


/****
 * ResponseListener callback which is responsible for giving the API response back to the presentation layer
 * Modified on: 4/3/19
 *****/
interface ResponseListener<T> {
    fun onStart()
    fun onFinish()
    fun onResponse(result: ApiResponse<T>)
}