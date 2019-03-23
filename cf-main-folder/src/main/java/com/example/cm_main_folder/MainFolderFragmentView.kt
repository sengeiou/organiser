package com.example.cm_main_folder

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cm_main_folder.di.MainFolderScreenConfigurator
import com.example.cm_recyclerview.FolderItemController
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
    lateinit var presenter: MainListPresenter
    private var fab_addFolder: FloatingActionButton? = null
    private lateinit var projectsRv: RecyclerView

    private val folderItemController = FolderItemController {
        presenter.newFragment()
    }
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
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        projectsRv.layoutManager = LinearLayoutManager(activity)
        projectsRv.adapter = easyAdapter
        val list = arrayListOf("Папка1", "asdas", "asdasd")
        easyAdapter.setItems(ItemList.create()
                .addAll(list, folderItemController)
        )
    }

    private fun initViews(view:View) {
        projectsRv = view.findViewById(R.id.projects_folder_rv)
    }

    override fun renderInternal(screenModel: MainFolderScreenModel) {

    }

    private fun initListeners() {
        fab_addFolder?.setOnClickListener {
            Log.d("PROJECTS", "ADD")
        }

    }
}