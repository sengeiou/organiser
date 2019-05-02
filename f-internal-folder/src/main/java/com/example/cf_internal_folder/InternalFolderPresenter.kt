package com.example.cf_internal_folder

import android.annotation.SuppressLint
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
import ru.surfstudio.standard.domain.folder.Project
import ru.surfstudio.standard.ui.navigation.AddFolderActivityRoute
import ru.surfstudio.standard.ui.navigation.AddProjectActivityRoute
import ru.surfstudio.standard.ui.navigation.InternalFolderFragmentRoute
import ru.surfstudio.standard.ui.navigation.ProjectActivityRoute
import javax.inject.Inject

@PerScreen
class InternalFolderPresenter @Inject constructor(basePresenterDependency: BasePresenterDependency,
                                                  private val fragmentNavigator: FragmentNavigator,
                                                  private val activityNavigator: ActivityNavigator,
                                                  private val folderInteractor: FolderInteractor)
    : BasePresenter<InternalFolderFragmentView>(basePresenterDependency) {

    private val sm = InternalFolderScreenModel()
    private val INTERNAL_FOLDER_PRESENTER = "InternalFolderPresenter"

    fun openAddFolderActivity(folderId: Long) {
        observeToAddFolderActivity()
        activityNavigator.startForResult(AddFolderActivityRoute(folderId))
    }

    @SuppressLint("LogNotTimber")
    private fun observeToAddFolderActivity() {
        activityNavigator.observeResult<Long>(AddFolderActivityRoute())
                .flatMap {
                    folderInteractor.loadFolderById(it.data)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.folderList.add(it)
                    view.render(sm)
                }, {
                    Log.e(INTERNAL_FOLDER_PRESENTER, it.message)
                })


    }


    fun openAddProjectActivity(folderId: Long?) {
        observeToAddProjectActivity()
        activityNavigator.startForResult(AddProjectActivityRoute(folderId))
    }

    @SuppressLint("LogNotTimber")
    private fun observeToAddProjectActivity() {
        activityNavigator.observeResult<Long>(AddProjectActivityRoute())
                .flatMap {
                    folderInteractor.loadProjectById(it.data)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.projectList.add(it)
                    view.render(sm)
                }, {
                    Log.e(INTERNAL_FOLDER_PRESENTER, it.message)
                }
                )
    }

    fun openFolder(folder: Folder) {
        fragmentNavigator.replace(InternalFolderFragmentRoute(folder), true, FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
    }

    fun loadFoldersAndProject(parentFolderId: Long) {
        loadFolders(parentFolderId)
        loadProjects(parentFolderId)
    }

    @SuppressLint("LogNotTimber")
    private fun loadProjects(parentFolderId: Long) {
        folderInteractor.loadProjects(parentFolderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.projectList = it as ArrayList<Project>
                    view.render(sm)
                }, {
                    Log.e(INTERNAL_FOLDER_PRESENTER, it.message)
                })
    }

    @SuppressLint("LogNotTimber")
    private fun loadFolders(parentFolderId: Long) {
        folderInteractor.loadFolders(parentFolderId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sm.folderList = it as ArrayList<Folder>
                    sm.loading = false
                    view.render(sm)
                }, {
                    Log.e(INTERNAL_FOLDER_PRESENTER, it.message)
                })
    }

    fun openProject(project: Project) {
        activityNavigator.start(ProjectActivityRoute(project.id))
    }
}