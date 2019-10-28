package daniyal.android.basewithkotlin.ui.dummyfragment

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
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

    override fun subscribeForNavigation() {
        super.subscribeForNavigation()


        mViewModel.navigateToSecondFragment.observe(this , Observer {
            Toast.makeText(activity, "navigate called", Toast.LENGTH_LONG).show()
        })

        mViewModel.response3.observe(this, Observer {

            Toast.makeText(activity, it.data!!.status.creditCount.toString(), Toast.LENGTH_LONG).show()
        })
    }

    override fun subscribeToShareLiveData() {
        super.subscribeToShareLiveData()

        mViewModel.userEntityData.observe(this,Observer{
            if(null != it && it.isNotEmpty())
            Toast.makeText(activity, it.last().id.toString(), Toast.LENGTH_LONG).show()
        })

    }


}
