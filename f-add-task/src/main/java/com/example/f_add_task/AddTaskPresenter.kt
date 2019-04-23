package com.example.f_add_task

import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import javax.inject.Inject

class AddTaskPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency)
    : BasePresenter<AddTaskActivityView>(basePresenterDependency) {
}