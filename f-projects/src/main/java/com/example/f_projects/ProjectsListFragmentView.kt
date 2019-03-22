package ru.surfstudio.standard.f_main.projects

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f_projects.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_projects_list.*
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.android.template.f_main.R
import ru.surfstudio.standard.f_main.projects.controllers.FolderItemController
import ru.surfstudio.standard.f_main.projects.di.ProjectsListScreenConfigurator
import javax.inject.Inject

/**
 * Вью TODO
 */
class ProjectsListFragmentView : BaseRenderableFragmentView<ProjectsListScreenModel>() {
    @Inject
    lateinit var presenter: ProjectsListPresenter
    var fab_addFolder: FloatingActionButton? = null
    lateinit var projectsRv:RecyclerView

    private val folderItemController = FolderItemController {
        Log.d("CLICK", "CLICKED item")
    }
    private val easyAdapter = EasyAdapter()

    override fun getScreenName() = "ProjectsListFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = ProjectsListScreenConfigurator(arguments ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        initViews()
        val view = inflater.inflate(R.layout.fragment_projects_list, container, false)
        projectsRv = view.findViewById(R.id.projects_rv)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        projectsRv.layoutManager = LinearLayoutManager(activity)
        projectsRv.adapter = easyAdapter
        val list = arrayListOf("Папка1","asdas","asdasd")
        easyAdapter.setItems(ItemList.create()
                .addAll(list,folderItemController)
        )
    }

    private fun initViews() {
        fab_addFolder = activity?.findViewById(R.id.projects_addFolder_fab)
    }

    override fun renderInternal(screenModel: ProjectsListScreenModel) {

    }

    private fun initListeners() {
        fab_addFolder?.setOnClickListener {
            Log.d("PROJECTS", "ADD folder")
        }

    }
}