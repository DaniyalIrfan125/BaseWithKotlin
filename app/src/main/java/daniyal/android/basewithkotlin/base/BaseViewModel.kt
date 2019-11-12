package daniyal.android.basewithkotlin.base

import androidx.lifecycle.ViewModel
import daniyal.android.basewithkotlin.architecture.SingleLiveEvent

open class BaseViewModel : ViewModel() {


    val showLoading = SingleLiveEvent<Boolean>()

  //  val response: SingleLiveEvent<ApiResponse<T>> = SingleLiveEvent()
}