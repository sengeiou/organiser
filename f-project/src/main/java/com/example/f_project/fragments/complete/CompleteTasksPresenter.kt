package com.example.f_project.fragments.complete

import android.util.Log
import com.example.i_project.ProjectInteractor
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import javax.inject.Inject

class CompleteTasksPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                                 private val projectInteractor: ProjectInteractor)
    : BasePresenter<CompleteTasksFragmentView>(basePresenterDependency) {
    private val COMPLETE_TASKS_PRESENTER = "CompleteTasksPresenter"
    private val sm = CompleteTasksScreenModel()
    override fun onFirstLoad() {
        projectInteractor.subscribeToCompleteTask()
                .subscribe({
                    sm.tasksList.add(it)
                    view.render(sm)
                },{
                    Log.e(COMPLETE_TASKS_PRESENTER,it.message)
                })
    }
}