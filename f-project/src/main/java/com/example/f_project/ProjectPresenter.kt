package com.example.f_project

import android.util.Log
import com.example.i_folder.FolderInteractor
import com.example.i_project.ProjectInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import javax.inject.Inject

@PerScreen
class ProjectPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                           private val folderInteractor: FolderInteractor,
                                           private val projectInteractor: ProjectInteractor)
    : BasePresenter<ProjectActivityView>(basePresenterDependency) {
    private val sm = ProjectScreenModel()
    private val PROJECT_PRESENTER = "ProjectPresenter"
    fun loadProjectInfo(projectId: Long) {
        folderInteractor.loadProjectById(projectId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.projectName = it.name
                    sm.projectDescription = it.description
                    view.render(sm)
                },{
                    Log.e(PROJECT_PRESENTER,it.message)
                })
        loadProjectsProgress(projectId)
    }

    override fun onLoad(viewRecreated: Boolean) {
        projectInteractor.subscribeToUpdateTasks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    loadProjectsProgress(view.getProjectId()!!)
                },{
                    Log.e(PROJECT_PRESENTER,it.message)
                })
    }

    private fun loadProjectsProgress(projectId: Long) {
        projectInteractor.calculateProjectsProgress(projectId)
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe {
                    sm.projectProgress = it
                    view.render(sm)
                }
    }
}