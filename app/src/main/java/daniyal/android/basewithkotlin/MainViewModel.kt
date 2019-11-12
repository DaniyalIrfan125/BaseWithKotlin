package daniyal.android.basewithkotlin

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import daniyal.android.basewithkotlin.base.BaseViewModel
import daniyal.android.basewithkotlin.data.remote.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : BaseViewModel() {

    val showProgressbar = ObservableBoolean(false)
    val Usertext = ObservableField<String>()


}