package ru.surfstudio.standard.f_main.projects

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_projects_list.*
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.template.f_main.R
import ru.surfstudio.standard.f_main.projects.di.ProjectsListScreenConfigurator
import javax.inject.Inject

/**
 * Вью TODO
 */
class ProjectsListFragmentView : BaseRenderableFragmentView<ProjectsListScreenModel>() {
    @Inject
    lateinit var presenter: ProjectsListPresenter
    var fab_addFolder: FloatingActionButton? = null

    override fun getScreenName() = "ProjectsListFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = ProjectsListScreenConfigurator(arguments ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        initViews()
       return inflater.inflate(R.layout.fragment_projects_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
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
        project_add.setOnClickListener {
            presenter.newFragment()
        }
    }
}