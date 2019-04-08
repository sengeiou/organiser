package com.example.cf_other_folder

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_other_folder.di.OtherFolderScreenConfigurator
import com.example.cm_recyclerview.FolderItemController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.other_toolbar.*
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import javax.inject.Inject

///**
// * Вью TODO
// */
class OtherFolderFragmentView : BaseRenderableFragmentView<OtherFolderScreenModel>() {
    @Inject
    lateinit var presenter: OtherFolderPresenter
    var fab_addFolder: FloatingActionButton? = null
    lateinit var projectsRv: RecyclerView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar

    lateinit var internalFolderNameTv:TextView

    private val FOLDER_ID:String = "FOLDER_ID"
    private val FOLDER_NAME:String = "FOLDER_NAME"

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
        val view = inflater.inflate(R.layout.fragment_other_folder_list, container, false)
        initViews(view)
        initToolbar()
        return view
    }

    private fun initToolbar() {
        internalFolderNameTv.text = arguments?.getString(FOLDER_NAME)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        projectsRv.layoutManager = LinearLayoutManager(activity)
        projectsRv.adapter = easyAdapter

    }

    private fun initViews(view:View) {
        internalFolderNameTv = view.findViewById(R.id.internal_folder_name_tv)
        projectsRv = view.findViewById(R.id.projects_folder_rv)
        toolbar = view.findViewById(R.id.toolbar_support)
    }

    override fun renderInternal(screenModel: OtherFolderScreenModel) {

    }

    private fun initListeners() {
        fab_addFolder?.setOnClickListener {
        }

    }
}