package daniyal.android.basewithkotlin

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import daniyal.android.basewithkotlin.base.BaseActivity
import daniyal.android.basewithkotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel
        get() = ViewModelProviders.of(this).get(MainViewModel::class.java)

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    //   var dataBinding: ActivityMainBinding? = null
    //var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.Usertext.set("base project")

//        dataBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)
//
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//
//        dataBinding!!.setVariable(BR.viewModel, viewModel)
//
//        viewModel!!.Usertext.set("hello daniyal")


    }
}
