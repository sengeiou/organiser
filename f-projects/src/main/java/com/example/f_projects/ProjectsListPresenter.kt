package ru.surfstudio.standard.f_main.projects

import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.fragment.ChildFragmentNavigator
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import javax.inject.Inject

class ProjectsListPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,val childFragmentNavigator: FragmentNavigator)
    :BasePresenter<ProjectsListFragmentView>(basePresenterDependency) {
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }
    fun newFragment(){
        childFragmentNavigator.replace(ProjectsListRoute(),true,TRANSIT_FRAGMENT_OPEN)
    }
}