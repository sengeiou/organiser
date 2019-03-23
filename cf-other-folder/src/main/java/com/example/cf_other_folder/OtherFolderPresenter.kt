package com.example.cf_other_folder

import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import javax.inject.Inject

class OtherFolderPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency, val fragmentNavigator: FragmentNavigator)
    : BasePresenter<OtherFolderFragmentView>(basePresenterDependency) {
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }
    fun newFragment(){
    }
}