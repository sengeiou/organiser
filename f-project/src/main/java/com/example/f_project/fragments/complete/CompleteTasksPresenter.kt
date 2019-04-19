package com.example.f_project.fragments.complete

import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import javax.inject.Inject

class CompleteTasksPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency)
    :BasePresenter<CompleteTasksFragmentView>(basePresenterDependency) {
}