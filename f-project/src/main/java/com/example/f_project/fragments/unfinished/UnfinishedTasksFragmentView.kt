package com.example.f_project.fragments.unfinished

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_project_recycler_view.TaskItemController
import com.example.f_project.R
import com.example.f_project.fragments.unfinished.di.UnfinishedTasksScreenConfigurator
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList
import javax.inject.Inject

/**
 * Вью TODO
 */
class UnfinishedTasksFragmentView : BaseRenderableFragmentView<UnfinishedTasksScreenModel>() {

    companion object {
        fun newInstance(projectId: Long): UnfinishedTasksFragmentView {
            val unfinishedTasksFragmentView = UnfinishedTasksFragmentView()
            val arguments = Bundle()
            arguments.putLong("PROJECT_ID", projectId)
            unfinishedTasksFragmentView.arguments = arguments
            return unfinishedTasksFragmentView
        }
    }

    private var PROJECT_ID: Long? = null
    private val easyAdapter = EasyAdapter()
    lateinit var addTaskFab: FloatingActionButton

    lateinit var tasksRecyclerView: RecyclerView

    private val itemController = TaskItemController({

    })

    @Inject
    lateinit var presenter: UnfinishedTasksPresenter

    override fun getScreenName() = "UnfinishedTasksFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = UnfinishedTasksScreenConfigurator(arguments
            ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_unfinished_tasks, container, false)
        initProjectId()
        initViews(view)
        return view
    }

    private fun initProjectId() {
        PROJECT_ID = arguments?.getLong("PROJECT_ID")
        Log.d("TASKSMY",PROJECT_ID.toString())
    }

    private fun initViews(view: View?) {
        addTaskFab = activity?.findViewById(R.id.project_add_task_fab)!!
        val tasksRecyclerView = view?.findViewById<RecyclerView>(R.id.project_unfinished_tesks_rv)
        tasksRecyclerView?.layoutManager = LinearLayoutManager(activity)
        tasksRecyclerView?.adapter = easyAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
    }

    override fun renderInternal(screenModel: UnfinishedTasksScreenModel) {
        easyAdapter.setItems(ItemList.create()
                .addAll(screenModel.tasksList,itemController))
    }

    private fun initListeners() {
        addTaskFab.setOnClickListener {
            presenter.openAddTaskActivity(PROJECT_ID!!)
        }
    }


}