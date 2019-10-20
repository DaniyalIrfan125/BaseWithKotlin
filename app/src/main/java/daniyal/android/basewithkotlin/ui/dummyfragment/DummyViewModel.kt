package daniyal.android.basewithkotlin.ui.dummyfragment

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import daniyal.android.basewithkotlin.architecture.SingleLiveEvent
import daniyal.android.basewithkotlin.base.BaseViewModel
import daniyal.android.basewithkotlin.data.local.entity.UserEntity
import daniyal.android.basewithkotlin.data.remote.repository.MainRepository
import javax.inject.Inject

class DummyViewModel @Inject constructor(private val mainRepository: MainRepository) : BaseViewModel() {


    val userEntityData: LiveData<List<UserEntity>> = mainRepository.showData()
    val navigateToSecondFragment = SingleLiveEvent<Void>()


    var text = ObservableField<String>()


    fun OnClick(){
        navigateToSecondFragment.call()
        mainRepository.addUser(UserEntity("eiza", "34"))
    }

}
