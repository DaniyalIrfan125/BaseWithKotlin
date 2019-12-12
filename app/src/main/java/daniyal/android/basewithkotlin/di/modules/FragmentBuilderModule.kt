package daniyal.android.basewithkotlin.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import daniyal.android.basewithkotlin.ui.dummyfragment.DummyFragment

/*
 * The module which provides the android injection service to fragments.
 */

@Suppress("unused")
@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeDummyFragment(): DummyFragment
}