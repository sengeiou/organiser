package com.example.f_add_project

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.f_add_project.di.AddProjectScreenConfigurator
import kotlinx.android.synthetic.main.activity_add_project.*
import kotlinx.android.synthetic.main.addfolder_toolbar.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import ru.surfstudio.standard.domain.folder.Project
import javax.inject.Inject
import android.view.MotionEvent



/**
 * Вью TODO
 */
class AddProjectActivityView : BaseRenderableActivityView<AddProjectScreenModel>() {

    @Inject
    lateinit var presenter: AddProjectPresenter

    override fun getScreenName() = "AddProjectActivityView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = AddProjectScreenConfigurator(intent)

    override fun getContentView(): Int = R.layout.activity_add_project

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        initListeners()
        initToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_ok) {
            presenter.addProject(Project(0, 1, "первый проект"))
        }
        return true
    }

    private fun initToolbar() {
        setSupportActionBar(addFolder_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Создание проекта"
    }

    override fun renderInternal(screenModel: AddProjectScreenModel) {

    }

    private fun initListeners() {

    }
}