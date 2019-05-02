package com.example.f_add_folder

import com.example.i_folder.AddFolderInteractor
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.ui.navigation.AddFolderActivityRoute
import javax.inject.Inject

@PerScreen
class AddFolderPresenter @Inject constructor(baseDependency: BasePresenterDependency,
                                             private val folderInteractor: AddFolderInteractor,
                                             private val activityNavigator: ActivityNavigator)
    : BasePresenter<AddFolderActivityView>(baseDependency) {
    private val sm = AddFolderScreenModel()
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    fun addFolder(folder: Folder) {
        if (validate(folder)) {
            folderInteractor.addFolder(folder)
                    ?.subscribe {
                        activityNavigator.finishWithResult(AddFolderActivityRoute(), it)
                    }
        }
    }

    private fun validate(folder: Folder): Boolean {
        return if (folder.name.isEmpty()) {
            sm.validate = false
            view.render(sm)
            false
        } else true
    }
}