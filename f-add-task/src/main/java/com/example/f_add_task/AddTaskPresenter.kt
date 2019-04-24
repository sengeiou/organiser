package com.example.f_add_task

import android.util.Log
import com.example.i_add_task.AddTaskInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.standard.ui.navigation.AddTaskActivityRoute
import javax.inject.Inject

class AddTaskPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                           private val addTaskInteractor: AddTaskInteractor,
                                           private val activityNavigator: ActivityNavigator)
    : BasePresenter<AddTaskActivityView>(basePresenterDependency) {
    private val ADD_TASK_PRESENTER = "AddTaskPresenter"
    fun addTask(task: ru.surfstudio.standard.domain.project.Task) {
        addTaskInteractor.addTask(task)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    activityNavigator.finishWithResult(AddTaskActivityRoute(),it)
                },{
                    Log.e(ADD_TASK_PRESENTER,it.message)
                })
    }
}