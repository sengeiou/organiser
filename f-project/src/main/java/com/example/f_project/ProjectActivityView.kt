package com.example.f_project

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import javax.inject.Inject
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cf_project_recycler_view.TaskItemController
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.ItemList

/**
 * Вью TODO
 */
class ProjectActivityView : BaseRenderableActivityView<ProjectScreenModel>() {
    val easyAdapter = EasyAdapter()

    lateinit var tasksRecyclerView:RecyclerView

    @Inject
    lateinit var presenter: ProjectPresenter
    val itemController = TaskItemController({

    })

    override fun getScreenName() = "ProjectActivityView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = ProjectScreenConfigurator(intent)

    override fun getContentView(): Int = R.layout.activity_project

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        initViews()
        initListeners()
        tasksRecyclerView.layoutManager = LinearLayoutManager(this)
        tasksRecyclerView.adapter = easyAdapter
        easyAdapter.setItems(ItemList.create()
                .addIf(true,itemController)

        )

    }

    private fun initViews() {
        tasksRecyclerView = findViewById(R.id.project_tesks_rv)
        val pb = findViewById<ProgressBar>(R.id.project_progress_pb)
        val tv = findViewById<TextView>(R.id.project_name_tv)
        pb.progress = 50
    }

    override fun renderInternal(screenModel: ProjectScreenModel) {

    }

    private fun initListeners() {

    }
}