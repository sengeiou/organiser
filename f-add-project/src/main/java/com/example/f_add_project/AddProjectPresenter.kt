package com.example.f_add_project

import android.util.Log
import com.example.i_add_project.AddProjectInteractor
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.domain.folder.Project
import javax.inject.Inject

@PerScreen
class AddProjectPresenter @Inject constructor(baseDependency: BasePresenterDependency,private val addProjectInteractor: AddProjectInteractor)
    : BasePresenter<AddProjectActivityView>(baseDependency) {

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    fun addProject(project:Project){
        addProjectInteractor.addProject(project)
                .subscribe{
                    Log.d("PROJECT",it.toString())
                }
    }
}