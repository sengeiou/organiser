package ru.surfstudio.standard.f_main.main

import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.f_main.projects.MainFolderRoute
import javax.inject.Inject

/**
 * Презентер главного экрана
 */
@PerScreen
class MainPresenter @Inject constructor(
        basePresenterDependency: BasePresenterDependency,
        val fragmentNavigator: FragmentNavigator
) : BasePresenter<MainActivityView>(basePresenterDependency) {

    private val sm = MainScreenModel()

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
        view.render(sm)
        fragmentNavigator.add(MainFolderRoute(),false,TRANSIT_FRAGMENT_OPEN)
    }
}