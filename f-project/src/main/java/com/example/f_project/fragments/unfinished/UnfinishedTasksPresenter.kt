package com.example.f_project.fragments.unfinished

import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import javax.inject.Inject

class UnfinishedTasksPresenter  @Inject constructor(basePresenterDependency: BasePresenterDependency)
    :BasePresenter<UnfinishedTasksFragmentView>(basePresenterDependency) {
}