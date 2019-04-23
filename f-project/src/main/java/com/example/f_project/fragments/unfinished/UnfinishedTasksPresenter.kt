package com.example.f_project.fragments.unfinished

import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.standard.ui.navigation.AddTaskActivityRoute
import javax.inject.Inject

class UnfinishedTasksPresenter  @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                                    private val activityNavigator: ActivityNavigator)
    :BasePresenter<UnfinishedTasksFragmentView>(basePresenterDependency) {
    fun openAddTaskActivity() {
        activityNavigator.start(AddTaskActivityRoute())
    }
}