package com.example.cm_main_folder

import android.content.Intent
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import ru.surfstudio.standard.ui.navigation.AddFolderActivityRoute
import ru.surfstudio.standard.ui.navigation.OtherFolderFragmentRoute
import javax.inject.Inject

class MainListPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                            val fragmentNavigator: FragmentNavigator,
                                            val activityNavigator: ActivityNavigator)
    : BasePresenter<MainFolderFragmentView>(basePresenterDependency) {
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    fun openFolder() {
        fragmentNavigator.replace(OtherFolderFragmentRoute(), true, TRANSIT_FRAGMENT_OPEN)
    }

    fun openAddFolderActivity(folderId: Int) {
        activityNavigator.start(AddFolderActivityRoute(folderId))
    }
}