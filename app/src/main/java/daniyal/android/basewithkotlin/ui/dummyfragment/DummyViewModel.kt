package daniyal.android.basewithkotlin.ui.dummyfragment

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import daniyal.android.basewithkotlin.architecture.SingleLiveEvent
import daniyal.android.basewithkotlin.base.BaseViewModel
import daniyal.android.basewithkotlin.data.local.entity.UserEntity
import daniyal.android.basewithkotlin.data.models.CoinMarketPojo
import daniyal.android.basewithkotlin.data.models.EmployePojo
import daniyal.android.basewithkotlin.data.models.ToDoPojo
import daniyal.android.basewithkotlin.data.remote.repository.MainRepository
import daniyal.android.basewithkotlin.data.remote.response.ApiResponse
import daniyal.android.basewithkotlin.data.remote.response.ResponseListener
import javax.inject.Inject

class DummyViewModel @Inject constructor(private val mainRepository: MainRepository) : BaseViewModel() {


    val userEntityData: LiveData<List<UserEntity>> = mainRepository.showData()
    val navigateToSecondFragment = SingleLiveEvent<Void>()

    val response: SingleLiveEvent<ApiResponse<List<EmployePojo>>> = SingleLiveEvent()
    val response1: SingleLiveEvent<ApiResponse<ToDoPojo>> = SingleLiveEvent()
    val response3: SingleLiveEvent<ApiResponse<CoinMarketPojo>> = SingleLiveEvent()
    val response4: SingleLiveEvent<ApiResponse<CoinMarketPojo>> = SingleLiveEvent()

    var text = ObservableField<String>()

    init {
//        mainRepository.getEmployeDetails(object : ResponseListener<List<EmployePojo>> {
//            override fun onStart() {
//
//            }
//
//            override fun onFinish() {
//
//            }
//
//            override fun onResponse(result: ApiResponse<List<EmployePojo>>) {
//                response.value = result
//            }
//
//        })
    }

    fun OnClick() {

//        navigateToSecondFragment.call()
//        mainRepository.addUser(UserEntity("eiza", "34"))

//        mainRepository.getEmployeDetails(object : ResponseListener<List<EmployePojo>> {
//            override fun onStart() {
//
//            }
//
//            override fun onFinish() {
//
//            }
//
//            override fun onResponse(result: ApiResponse<List<EmployePojo>>) {
//                response.value = result
//            }
//
//        })

//        mainRepository.getToDo(object : ResponseListener<ToDoPojo> {
//            override fun onStart() {
//
//            }
//
//            override fun onFinish() {
//
//            }
//
//            override fun onResponse(result: ApiResponse<ToDoPojo>) {
//                response1.value = result
//            }
//
//        })


        mainRepository.getCoinMarketDetails("9bcd6afc-3f2a-44eb-b34f-ef552a1fe962", "1", "20", object : ResponseListener<CoinMarketPojo> {
            override fun onStart() {
                showLoading.value = true
            }

            override fun onFinish() {
                showLoading.value = false
            }

            override fun onResponse(result: ApiResponse<CoinMarketPojo>) {
                response3.value = result
            }

        })
    }

    fun callMarketApi() {

        mainRepository.getCoinMarketDetails("9bcd6afc-3f2a-44eb-b34f-ef552a1fe962", "1", "20", object : ResponseListener<CoinMarketPojo> {
            override fun onStart() {
                showLoading.value = true
            }

            override fun onFinish() {
                showLoading.value = false
            }

            override fun onResponse(result: ApiResponse<CoinMarketPojo>) {
                response4.value = result
            }

        })

    }

}
