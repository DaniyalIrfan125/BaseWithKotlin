package daniyal.android.basewithkotlin.ui.dummyfragment

import androidx.databinding.ObservableField
import daniyal.android.basewithkotlin.base.BaseViewModel
import daniyal.android.basewithkotlin.data.remote.repository.MainRepository
import javax.inject.Inject

class DummyViewModel @Inject constructor(mainRepository: MainRepository)  : BaseViewModel() {

    init{

        mainRepository.login()
    }
    var text = ObservableField<String>()
}
