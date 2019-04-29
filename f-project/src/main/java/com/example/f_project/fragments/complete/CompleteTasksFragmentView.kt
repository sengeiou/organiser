package com.example.f_project.fragments.complete

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_project_recycler_view.EasyAdapterWithSwipe
import com.example.cf_project_recycler_view.SimpleItemTouchHelperCallback
import com.example.cf_project_recycler_view.TaskItemController
import com.example.f_project.R
import com.example.f_project.fragments.complete.di.CompleteTasksScreenConfigurator
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.easyadapter.ItemList
import javax.inject.Inject

/**
 * Вью
 */
class CompleteTasksFragmentView : BaseRenderableFragmentView<CompleteTasksScreenModel>() {
    companion object {
        fun newInstance(projectId: Long): CompleteTasksFragmentView {
            val completeTaskFragmentView = CompleteTasksFragmentView()
            val arguments = Bundle()
            arguments.putLong("PROJECT_ID", projectId)
            completeTaskFragmentView.arguments = arguments
            return completeTaskFragmentView
        }
    }

    private var PROJECT_ID: Long? = null

    val easyAdapter = EasyAdapterWithSwipe({
        presenter.deleteTask(it)
    }, {
        presenter.doNotCompleteTask(it)
    })


    val taskItemController = TaskItemController({

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
    ): View {
        val view = inflater.inflate(R.layout.fragment_complete_tasks, container, false)
        initViews(view)
        initProjectId()
        return view
    }

    private fun initProjectId() {
        PROJECT_ID = arguments?.getLong("PROJECT_ID")
    }

    private fun initViews(view: View) {
        val tasksRecyclerView = view.findViewById<RecyclerView>(R.id.project_complete_tesks_rv)
        tasksRecyclerView.layoutManager = LinearLayoutManager(activity)
        tasksRecyclerView.adapter = easyAdapter
        val callback = SimpleItemTouchHelperCallback(easyAdapter, context!!)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(tasksRecyclerView)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
        presenter.loadCompletedTasks(PROJECT_ID!!)
    }

    override fun renderInternal(screenModel: CompleteTasksScreenModel) {
        easyAdapter.setItems(ItemList.create()
                .addAll(screenModel.tasksList, taskItemController)
        )
    }

    private fun initListeners() {

    }
}