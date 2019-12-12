package daniyal.android.basewithkotlin.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import daniyal.android.basewithkotlin.MainViewModel
import daniyal.android.basewithkotlin.utils.NetworkUtils
import javax.inject.Inject

/**
 * Base Activity class
 */

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(),
        HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewDataBinding: T
    protected lateinit var mViewModel: V

    /**
     * viewModel variable that will get value from activity which it will implement this
     * we will use this variable viewModel to bind with view through databinding
     */
    abstract val viewModel: Class<V>

    /**
     * layoutId variable to get layout value from activity which will implement this layoutId
     * we will use this layoutId for databinding
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * bindingVariable which will bind with view
     */

    abstract val bindingVariable: Int


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databindingWithViewModel()
    }

    /**
     * Function to perform databinding and attaching viewmodel with view
     */
    private fun databindingWithViewModel() {
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModel)
        mViewDataBinding.setVariable(bindingVariable, mViewModel)
        mViewDataBinding.executePendingBindings()

    }

    fun isNetworkConnected(): Boolean {
        return NetworkUtils().isNetworkConnected(applicationContext)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onBackPressed() {
        if ((mViewModel as MainViewModel).showProgressbar.get())
            return
        else
            super.onBackPressed()
    }
}