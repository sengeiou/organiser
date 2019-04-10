package com.example.f_add_folder

import android.util.Log
import com.example.i_folder.AddFolderInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.ui.navigation.AddFolderActivityRoute
import javax.inject.Inject

@PerScreen
class AddFolderPresenter @Inject constructor(baseDependency: BasePresenterDependency,
                                             val folderInteractor: AddFolderInteractor,
                                             private val activityNavigator: ActivityNavigator)
    : BasePresenter<AddFolderActivityView>(baseDependency) {
    private val sm = AddFolderScreenModel()
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    fun addFolder(folder: Folder) {
        if (validate(folder)) {
            folderInteractor.addFolder(folder)
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe {
                        activityNavigator.finishWithResult(AddFolderActivityRoute(), it)
                        Log.d("myScreen", it.toString())
                    }
        }
    }

    fun validate(folder: Folder): Boolean {
        if (folder.name.isEmpty()) {
            sm.validate = false
            view.render(sm)
            return false
        } else return true
    }
}