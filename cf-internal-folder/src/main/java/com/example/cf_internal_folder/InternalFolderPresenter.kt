package com.example.cf_internal_folder

import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.example.i_folder.FolderInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.android.core.mvp.presenter.BasePresenter
import ru.surfstudio.android.core.mvp.presenter.BasePresenterDependency
import ru.surfstudio.android.core.ui.navigation.activity.navigator.ActivityNavigator
import ru.surfstudio.android.core.ui.navigation.fragment.FragmentNavigator
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.ui.navigation.AddFolderActivityRoute
import ru.surfstudio.standard.ui.navigation.InternalFolderFragmentRoute
import javax.inject.Inject

@PerScreen
class InternalFolderPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                                  private val fragmentNavigator: FragmentNavigator,
                                                  private val activityNavigator: ActivityNavigator,
                                                  private val folderInteractor: FolderInteractor)
    : BasePresenter<InternalFolderFragmentView>(basePresenterDependency) {

    private val sm = InternalFolderScreenModel()

    override fun onLoad(viewRecreated: Boolean) {
        super.onLoad(viewRecreated)
    }

    override fun onFirstLoad() {
        super.onFirstLoad()
        observeToAddFolderActivity()
    }
    private fun observeToAddFolderActivity(){
        activityNavigator.observeResult<Long>(AddFolderActivityRoute())
                .flatMap {
                    folderInteractor.loadFolderById(it.data)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    sm.folderList.add(it)
                    view.render(sm)
                }
    }

    fun loadFolders(parentFolderId: Long) {
        folderInteractor.loadFolders(parentFolderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    sm.folderList = it as ArrayList<Folder>
                    sm.loading = false
                    view.render(sm)
                }
    }

    fun openAddFolderActivity(folderId: Long) {
        activityNavigator.startForResult(AddFolderActivityRoute(folderId))
    }

    fun openFolder(folder:Folder) {
        fragmentNavigator.replace(InternalFolderFragmentRoute(folder), true, FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
    }
}