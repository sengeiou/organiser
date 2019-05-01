package com.example.f_project.fragments.unfinished

import android.util.Log
import com.example.i_project.ProjectInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.standard.domain.project.Task
import ru.surfstudio.standard.ui.navigation.AddTaskActivityRoute
import javax.inject.Inject

class UnfinishedTasksPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                                   private val activityNavigator: ActivityNavigator,
                                                   private val projectInteractor: ProjectInteractor)
    : BasePresenter<UnfinishedTasksFragmentView>(basePresenterDependency) {
    private val UNFINISHED_TASK_PRESENTER = "UnfinishedTaskPresenter"
    private val sm = UnfinishedTasksScreenModel()

    override fun onFirstLoad() {
        projectInteractor.subscribeToUnfinishedTask()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.tasksList.add(it)
                    view.render(sm)
                }, {
                    Log.e(UNFINISHED_TASK_PRESENTER, it.message)
                })
    }

    fun openAddTaskActivity(projectId: Long) {
        observeToAddTaskActivity()
        activityNavigator.startForResult(AddTaskActivityRoute(projectId))
    }

    //TODO добавить прогресс
    fun loadUnfinishedTasks(projectId: Long) {
        projectInteractor.loadUnfinishedTasks(projectId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(UNFINISHED_TASK_PRESENTER,it.toString())
                    sm.tasksList = it as ArrayList<Task>
                    view.render(sm)
                }, {
                    Log.e(UNFINISHED_TASK_PRESENTER, it.message)
                })
    }

    private fun observeToAddTaskActivity() {
        activityNavigator.observeResult<Long>(AddTaskActivityRoute())
                .flatMap {
                    projectInteractor.loadTask(it.data)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.tasksList.add(it)
                    view.render(sm)
                }, {
                    Log.e(UNFINISHED_TASK_PRESENTER, it.message)
                })
    }

    /**
     * Добавление задачи в список завершенных. TODO написать добавление задачи в завершенный список
     * @param position позиция элемента в RecyclerView,потом используется для удаления элемента из ScreenModel (в sm индексы с 0)
     */
    fun completeTask(position: Int) {
        val positionInSm = position - 1
        val taskToComplete = sm.tasksList[positionInSm]
        sm.tasksList.removeAt(positionInSm)
        projectInteractor.completeTask(taskToComplete)
    }

    fun deleteTask(position: Int) {
        val positionInSm = position - 1
        val taskToDelete = sm.tasksList[positionInSm]
        sm.tasksList.removeAt(positionInSm)
        projectInteractor.deleteTask(taskToDelete)
    }
}