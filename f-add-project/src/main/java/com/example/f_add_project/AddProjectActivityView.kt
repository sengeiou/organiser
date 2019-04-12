package com.example.f_add_project

import android.app.DatePickerDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import com.example.f_add_project.datepicker.DatePickerFragment
import com.example.f_add_project.di.AddProjectScreenConfigurator
import kotlinx.android.synthetic.main.activity_add_project.*
import kotlinx.android.synthetic.main.add_project_toolbar.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import ru.surfstudio.standard.domain.folder.Project
import javax.inject.Inject


/**
 * Вью TODO
 */
class AddProjectActivityView : BaseRenderableActivityView<AddProjectScreenModel>() {

    val beginDateDialogListener =
            DatePickerDialog.OnDateSetListener { datePicker: DatePicker, year: Int, month: Int, day: Int ->
               val monthFromOne = month+1
                addProject_begindate_tv.text = "$day/$monthFromOne/$year"
            }
    val endDateDialogListener =
            DatePickerDialog.OnDateSetListener { datePicker: DatePicker, year: Int, month: Int, day: Int ->
                val monthFromOne = month+1
                addProject_enddate_tv.text = "$day/$monthFromOne/$year"
            }

    @Inject
    lateinit var presenter: AddProjectPresenter

    private val DIALOG_DATE = 1

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
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun initToolbar() {
        setSupportActionBar(add_project_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Создание проекта"
    }

    override fun renderInternal(screenModel: AddProjectScreenModel) {

    }

    private fun initListeners() {
        beginDateTvListener()
        endDateTvListener()
        backButtonListener()
    }

    private fun endDateTvListener() {
        addProject_enddate_tv.setOnClickListener {
            val endDateFragment = DatePickerFragment()
            endDateFragment.setListener(endDateDialogListener)
            endDateFragment.show(supportFragmentManager, "datePicker")
        }
    }

    private fun beginDateTvListener() {
        addProject_begindate_tv.setOnClickListener {
            val beginDateFragment = DatePickerFragment()
            beginDateFragment.setListener(beginDateDialogListener)
            beginDateFragment.show(supportFragmentManager, "datePicker")
        }
    }

    private fun backButtonListener() {
        add_project_toolbar.setNavigationOnClickListener {
            Log.d("MYLIST","LISTLIST")
        }
    }
}