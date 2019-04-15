package com.example.f_add_project

import android.util.AndroidException
import android.util.Log
import com.example.i_add_project.AddProjectInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.domain.folder.Project
import ru.surfstudio.standard.ui.navigation.AddProjectActivityRoute
import javax.inject.Inject

@PerScreen
class AddProjectPresenter @Inject constructor(baseDependency: BasePresenterDependency,
                                              private val addProjectInteractor: AddProjectInteractor,
                                              private val activityNavigator: ActivityNavigator)
    : BasePresenter<AddProjectActivityView>(baseDependency) {

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    fun addProject(project:Project){
        addProjectInteractor.addProject(project)
                .subscribe{
                activityNavigator.finishWithResult(AddProjectActivityRoute(),it)
                }
    }
}