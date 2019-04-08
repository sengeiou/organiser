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
import com.example.cm_recyclerview.EmptyFolderItemController
import com.example.cm_recyclerview.FolderItemController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import ru.surfstudio.standard.domain.folder.Folder
import java.util.ArrayList
import javax.inject.Inject

/**
 * Вью TODO
 */
class MainFolderFragmentView : BaseRenderableFragmentView<MainFolderScreenModel>() {


    @Inject
    lateinit var presenter: MainFolderPresenter

    private val FOLDER_ID: Int = 1

    private var fab_addFolder: FloatingActionButton? = null
    private lateinit var projectsRv: RecyclerView

    private val folderItemController = FolderItemController {
        Log.d("myScreen",it.toString())
        presenter.openFolder(it)
    }
    private val noDataItemController = EmptyFolderItemController()

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
        fab_addFolder = activity?.findViewById(R.id.projects_add_folder_fab)
    }

    override fun renderInternal(screenModel: MainFolderScreenModel) {
        easyAdapter.setItems(ItemList.create()
                .addIf(!screenModel.hasContent(), noDataItemController)
                .addAll(screenModel.folderList,folderItemController)
        )
    }
    private fun initListeners() {
        fab_addFolder?.setOnClickListener {
            presenter.openAddFolderActivity(FOLDER_ID)
        }

    }
}