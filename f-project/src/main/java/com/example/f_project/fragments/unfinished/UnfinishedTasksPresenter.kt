package com.example.f_project.fragments.unfinished

import android.util.Log
import com.example.i_project.ProjectInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.standard.ui.navigation.AddTaskActivityRoute
import javax.inject.Inject

class UnfinishedTasksPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                                   private val activityNavigator: ActivityNavigator,
                                                   private val projectInteractor: ProjectInteractor)
    : BasePresenter<UnfinishedTasksFragmentView>(basePresenterDependency) {
    private val UNFINISHED_TASK_PRESENTER = "UnfinishedTaskPresenter"
    private val sm = UnfinishedTasksScreenModel()
    fun openAddTaskActivity(projectId: Long) {
        observeToAddTaskActivity()
        activityNavigator.startForResult(AddTaskActivityRoute(projectId))
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
     * @param position позиция элемента в RecyclerView,потои используется для удаления элемента из ScreenModel
     */
    fun completeTask(position: Int) {
        val posInSm = position - 1
        sm.tasksList.removeAt(posInSm)
    }
}