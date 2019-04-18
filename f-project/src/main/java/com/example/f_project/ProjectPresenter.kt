package com.example.f_project

import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.dagger.scope.PerScreen
import javax.inject.Inject

@PerScreen
class ProjectPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency)
    :BasePresenter<ProjectActivityView>(basePresenterDependency){
}