package daniyal.android.basewithkotlin.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import daniyal.android.basewithkotlin.MainActivity
import daniyal.android.basewithkotlin.SharedViewModel
import daniyal.android.basewithkotlin.di.Injectable
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    protected lateinit var sharedViewModel: BaseViewModel

    private var mActivity: BaseActivity<*, *>? = null
    private lateinit var mViewDataBinding: T
    protected lateinit var mViewModel: V

    abstract val layoutId: Int
    abstract val viewModel: Class<V>
    abstract val bindingVariable: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModel)

        subscribeForNavigation()

        sharedViewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        subscribeToShareLiveData()


        mViewModel.showLoading.observe(this, Observer {
            if (it)
                showLoading()
            else
                hideLoading()
        })
    }

    open fun subscribeToShareLiveData() {

    }

    open fun subscribeForNavigation() {

    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return mViewDataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(bindingVariable, mViewModel)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>)
            this.mActivity = context
    }

    val isNetworkConnected: Boolean
        get() = mActivity != null && mActivity!!.isNetworkConnected()

    fun showLoading() {
        (mActivity as MainActivity).showLoading()
    }

    fun hideLoading() {
        (mActivity as MainActivity).stopLoading()
    }
}