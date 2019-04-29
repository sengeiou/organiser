package com.example.f_project.fragments.complete

import android.util.Log
import com.example.i_project.ProjectInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.standard.domain.project.Task
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
                }, {
                    Log.e(COMPLETE_TASKS_PRESENTER, it.message)
                })
    }

    fun loadCompletedTasks(projectId: Long) {
        projectInteractor.loadCompletedTasks(projectId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.tasksList = it as ArrayList<Task>
                    view.render(sm)
                }, {
                    Log.e(COMPLETE_TASKS_PRESENTER, it.message)
                })
    }

    fun doNotCompleteTask(position: Int) {
        val positionInSm = position - 1
        val taskToUnfinish = sm.tasksList[positionInSm]
        sm.tasksList.removeAt(positionInSm)
        projectInteractor.doNotCompleteTask(taskToUnfinish)
    }

    fun deleteTask(position: Int) {
        val positionInSm = position - 1
        sm.tasksList.removeAt(positionInSm)
    }
}