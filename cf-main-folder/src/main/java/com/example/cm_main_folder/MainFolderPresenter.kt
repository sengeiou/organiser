package com.example.cm_main_folder

import android.util.Log
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.example.i_folder.FolderInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.ui.navigation.AddFolderActivityRoute
import ru.surfstudio.standard.ui.navigation.OtherFolderFragmentRoute
import ru.surfstudio.standard.ui.placeholder.LoadState
import javax.inject.Inject

class MainFolderPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                              private val fragmentNavigator: FragmentNavigator,
                                              private val activityNavigator: ActivityNavigator,
                                              private val folderInteractor: FolderInteractor)
    : BasePresenter<MainFolderFragmentView>(basePresenterDependency) {

    private val FOLDER_ID: Int = 1
    private val sm = MainFolderScreenModel()

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
        folderInteractor.loadFolders(FOLDER_ID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    sm.folderList = it
                    Log.d("myScreen","Вызов")
                    view.render(sm)
                }

    }

    fun openFolder(folder:Folder) {
        fragmentNavigator.replace(OtherFolderFragmentRoute(folder), true, TRANSIT_FRAGMENT_OPEN)
    }

    fun openAddFolderActivity(folderId: Int) {
        activityNavigator.start(AddFolderActivityRoute(folderId))
    }
}