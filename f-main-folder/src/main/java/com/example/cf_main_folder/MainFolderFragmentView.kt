package com.example.cf_main_folder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_main_folder.di.MainFolderScreenConfigurator
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

/**
 * Вью TODO
 */
class MainFolderFragmentView : BaseRenderableFragmentView<MainFolderScreenModel>() {


    @Inject
    lateinit var presenter: MainFolderPresenter

    private val FOLDER_ID: Long = 1
    lateinit var progressBar: ProgressBar

    private var fab_addFolder: FloatingActionButton? = null
    private var fab_addProject: FloatingActionButton? = null


    private lateinit var projectsRv: RecyclerView
    private val projectItemController = ProjectItemController {
        presenter.openProject(it.id)
    }
    private val folderItemController = FolderItemController {
        presenter.openFolder(it)
    }
    private val noDataItemController = EmptyFolderItemController()
    private val folderHeaderItemController = HeaderFolderItemController()
    private val projectHeaderItemController = HeaderProjectItemController()

    private val easyAdapter = EasyAdapter()

    override fun getScreenName() = "ProjectsListFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = MainFolderScreenConfigurator(arguments
            ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main_folder_list, container, false)
        initViews(view)
        initRecycler()
        return view
    }

    private fun initRecycler() {
        projectsRv.layoutManager = LinearLayoutManager(activity)
        projectsRv.adapter = easyAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        easyAdapter.setItems(ItemList.create()
        )
    }

    private fun initViews(view: View) {
        projectsRv = view.findViewById(R.id.projects_folder_rv)
        progressBar = view.findViewById(R.id.rv_progressbar)
        fab_addFolder = activity?.findViewById(R.id.projects_add_folder_fab)
        fab_addProject = activity?.findViewById(R.id.projects_add_project_fab)
    }

    override fun renderInternal(screenModel: MainFolderScreenModel) {
        easyAdapter.setItems(ItemList.create()
                .addIf(screenModel.hasFolders(), folderHeaderItemController)
                .addIf(!screenModel.hasContent(), noDataItemController)
                .addAll(screenModel.folderList, folderItemController)
                .addIf(screenModel.hasProjects(), projectHeaderItemController)
                .addAll(screenModel.projectList, projectItemController)

        )
        if (screenModel.loading) {
            progressBar.visibility = View.VISIBLE
        } else progressBar.visibility = View.INVISIBLE
    }

    private fun initListeners() {
        fab_addFolder?.setOnClickListener {
            presenter.openAddFolderActivity(FOLDER_ID)
        }
        fab_addProject?.setOnClickListener {
            presenter.openAddProjectActivity(FOLDER_ID)
        }

    }
}