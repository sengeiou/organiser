package com.example.f_project

import android.os.Bundle
import android.os.PersistableBundle
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import javax.inject.Inject
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.example.cf_project_recycler_view.TaskItemController
import com.example.f_project.adapter.TasksPagerAdapter
import com.example.f_project.di.ProjectScreenConfigurator
import kotlinx.android.synthetic.main.activity_project.*
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
        initViewPager()
        initListeners()
    }

    private fun initViewPager() {
        val pagerDapater = TasksPagerAdapter(supportFragmentManager)
        project_viewpager.adapter = pagerDapater
        project_tabs.setupWithViewPager(project_viewpager)
    }

    private fun initViews() {

        val pb = findViewById<ProgressBar>(R.id.project_progress_pb)
        val tv = findViewById<TextView>(R.id.project_name_tv)
        pb.progress = 50
    }

    override fun renderInternal(screenModel: ProjectScreenModel) {

    }

    private fun initListeners() {

    }
}