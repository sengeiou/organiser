package com.example.f_project.fragments.complete

import android.os.Bundle
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import com.example.f_project.R
import javax.inject.Inject
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_project_recycler_view.TaskItemController
import com.example.f_project.fragments.complete.di.CompleteTasksScreenConfigurator
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

/**
 * Вью TODO
 */
class CompleteTasksFragmentView : BaseRenderableFragmentView<CompleteTasksScreenModel>() {
    val easyAdapter = EasyAdapter()

    lateinit var tasksRecyclerView:RecyclerView

    val itemController = TaskItemController({

    })

    @Inject
    lateinit var presenter: CompleteTasksPresenter

    override fun getScreenName() = "CompleteTasksFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = CompleteTasksScreenConfigurator(arguments
            ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ):View {
        val view = inflater.inflate(R.layout.fragment_complete_tasks, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view:View) {
       val tasksRecyclerView = view.findViewById<RecyclerView>(R.id.project_tesks_rv)
        tasksRecyclerView.layoutManager = LinearLayoutManager(activity)
        tasksRecyclerView.adapter = easyAdapter
        easyAdapter.setItems(ItemList.create()
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)
                .addIf(true,itemController)

        )

    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
    }

    override fun renderInternal(screenModel: CompleteTasksScreenModel) {

    }

    private fun initListeners() {

    }
}