package daniyal.android.basewithkotlin

import androidx.databinding.ObservableField
import daniyal.android.basewithkotlin.base.BaseViewModel
import daniyal.android.basewithkotlin.data.remote.repository.MainRepository
import javax.inject.Inject

class MainViewModel : BaseViewModel() {

    val Usertext = ObservableField<String>()
}