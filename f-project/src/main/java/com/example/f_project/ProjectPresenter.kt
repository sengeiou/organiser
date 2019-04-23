package com.example.f_project

import android.util.Log
import com.example.i_folder.FolderInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import javax.inject.Inject

@PerScreen
class ProjectPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency, val folderInteractor: FolderInteractor)
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
    }
}