package daniyal.android.basewithkotlin.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import daniyal.android.basewithkotlin.ViewModelFactory
import daniyal.android.basewithkotlin.di.key.ViewModelKey
import daniyal.android.basewithkotlin.ui.dummyfragment.DummyViewModel

/****
 * View Model module which provides the viewmodelfactory and viewmodel instances
 *****/
@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DummyViewModel::class)
    fun bindDummyViewModel(dummyViewModel: DummyViewModel): ViewModel

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}