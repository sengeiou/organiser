package com.example.cf_internal_folder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_internal_folder.di.InternalFolderScreenConfigurator
import com.example.cm_recyclerview.folder.EmptyFolderItemController
import com.example.cm_recyclerview.folder.FolderItemController
import com.example.cm_recyclerview.folder.HeaderFolderItemController
import com.example.cm_recyclerview.project.HeaderProjectItemController
import com.example.cm_recyclerview.project.ProjectItemController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import javax.inject.Inject

///**
// * Вью
// */
class InternalFolderFragmentView : BaseRenderableFragmentView<InternalFolderScreenModel>() {
    @Inject
    lateinit var presenter: InternalFolderPresenter
    var fab_addFolder: FloatingActionButton? = null
    var fab_addProject: FloatingActionButton? = null
    lateinit var projectsRv: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    lateinit var internalFolderNameTv: TextView

    private val folderItemController = FolderItemController {
        presenter.openFolder(it)
    }

    private val projectItemController = ProjectItemController {

    }
    private val folderHeaderItemController = HeaderFolderItemController()
    private val projectHeaderItemController = HeaderProjectItemController()

    private val noDataItemController = EmptyFolderItemController()


    var FOLDER_ID: Long? = null
    private val easyAdapter = EasyAdapter()

    override fun getScreenName() = "ProjectsListFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = InternalFolderScreenConfigurator(arguments
            ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_other_folder_list, container, false)
        initViews(view)
        initToolbar()
        initFolderId()
        return view
    }

    private fun initFolderId() {
        FOLDER_ID = arguments?.getLong("FOLDER_ID")
    }

    private fun initToolbar() {
        internalFolderNameTv.text = arguments?.getString("FOLDER_NAME")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        presenter.loadFoldersAndProject(FOLDER_ID!!)
        projectsRv.layoutManager = LinearLayoutManager(activity)
        projectsRv.adapter = easyAdapter

    }

    private fun initViews(view: View) {
        fab_addFolder = activity?.findViewById(R.id.projects_add_folder_fab)
        fab_addProject = activity?.findViewById(R.id.projects_add_project_fab)
        progressBar = view.findViewById(R.id.rv_progressbar)
        internalFolderNameTv = view.findViewById(R.id.internal_folder_name_tv)
        projectsRv = view.findViewById(R.id.projects_folder_rv)
        toolbar = view.findViewById(R.id.toolbar_support)
    }

    override fun renderInternal(screenModel: InternalFolderScreenModel) {
        easyAdapter.setItems(ItemList.create()
                .addIf(screenModel.hasFolders(),folderHeaderItemController)
                .addIf(!screenModel.hasContent(), noDataItemController)
                .addAll(screenModel.folderList, folderItemController)
                .addIf(screenModel.hasProjects(),projectHeaderItemController)
                .addAll(screenModel.projectList, projectItemController))
        if (screenModel.loading) {
            progressBar.visibility = View.VISIBLE
        } else progressBar.visibility = View.INVISIBLE
    }

    private fun initListeners() {
        fab_addFolder?.setOnClickListener { it ->
            FOLDER_ID.let { folderId ->
                presenter.openAddFolderActivity(folderId!!)
            }
        }

        fab_addProject?.setOnClickListener {
            FOLDER_ID.let { folderId ->
                presenter.openAddProjectActivity(folderId)
            }
        }

    }
}