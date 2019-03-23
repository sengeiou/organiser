package com.example.cm_main_folder

import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import ru.surfstudio.standard.ui.navigation.OtherFolderFragmentRoute
import javax.inject.Inject

class MainListPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,val childFragmentNavigator: FragmentNavigator)
    :BasePresenter<MainFolderFragmentView>(basePresenterDependency) {
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }
    fun newFragment(){
        childFragmentNavigator.replace(OtherFolderFragmentRoute(),true, TRANSIT_FRAGMENT_OPEN)
    }
}