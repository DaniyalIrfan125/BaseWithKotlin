package daniyal.android.basewithkotlin.ui.dummyfragment

import android.os.Bundle
import daniyal.android.basewithkotlin.BR
import daniyal.android.basewithkotlin.R
import daniyal.android.basewithkotlin.base.BaseFragment
import daniyal.android.basewithkotlin.databinding.DummyFragmentBinding

class DummyFragment : BaseFragment<DummyFragmentBinding, DummyViewModel>() {

    override val layoutId: Int
        get() = R.layout.dummy_fragment
    override val viewModel: Class<DummyViewModel>
        get() = DummyViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.text.set("fuck")
    }

    override fun subscribeToShareLiveData() {
        super.subscribeToShareLiveData()

    }

}
