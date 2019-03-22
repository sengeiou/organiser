package ru.surfstudio.standard.f_main.otherfolder

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.android.template.f_main.R
import ru.surfstudio.standard.f_main.otherfolder.di.OtherFolderScreenConfigurator
import ru.surfstudio.standard.f_main.projects.controllers.FolderItemController
import javax.inject.Inject

/**
 * Вью TODO
 */
class OtherFolderFragmentView : BaseRenderableFragmentView<OtherFolderScreenModel>() {
    @Inject
    lateinit var presenter: OtherFolderPresenter
    var fab_addFolder: FloatingActionButton? = null
    lateinit var projectsRv:RecyclerView
    lateinit var tolbar:Toolbar

    private val folderItemController = FolderItemController {
        Log.d("CLICK", "CLICKED item")
    }
    private val easyAdapter = EasyAdapter()

    override fun getScreenName() = "ProjectsListFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = OtherFolderScreenConfigurator(arguments
            ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        initViews()
        val view = inflater.inflate(R.layout.fragment_other_folder_list, container, false)
        projectsRv = view.findViewById(R.id.projects_other_folder_rv)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        projectsRv.layoutManager = LinearLayoutManager(activity)
        projectsRv.adapter = easyAdapter
        val list = arrayListOf("Папка6","asdas","asdasd")
        easyAdapter.setItems(ItemList.create()
                .addAll(list,folderItemController)
        )
    }

    private fun initViews() {
    }

    override fun renderInternal(screenModel: OtherFolderScreenModel) {

    }

    private fun initListeners() {
        fab_addFolder?.setOnClickListener {
            Log.d("PROJECTS", "ADD")
        }

    }
}