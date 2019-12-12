package daniyal.android.basewithkotlin.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import daniyal.android.basewithkotlin.MainActivity

/*
 * The module which provides the android injection service to activities
 */
@Suppress("unused")
@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity
}