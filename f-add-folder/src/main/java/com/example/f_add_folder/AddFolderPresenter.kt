package com.example.f_add_folder

import android.util.Log
import com.example.i_folder.AddFolderInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

@PerScreen
class AddFolderPresenter @Inject constructor(baseDependency: BasePresenterDependency,
                                              val folderInteractor: AddFolderInteractor,
                                             private val activityNavigator: ActivityNavigator)
    : BasePresenter<AddFolderActivityView>(baseDependency) {
    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    fun addFolder(folder: Folder) {
        folderInteractor.addFolder(folder)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    Log.d("myScreen","ЭКРАН")


                }
    }
}