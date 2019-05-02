package com.example.f_add_project

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import com.example.cf_datepicker.DatePickerDialogFragment
import com.example.f_add_project.di.AddProjectScreenConfigurator
import kotlinx.android.synthetic.main.activity_add_project.*
import kotlinx.android.synthetic.main.add_project_toolbar.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import ru.surfstudio.standard.domain.folder.Project
import java.util.*
import javax.inject.Inject


/**
 * Вью
 */
class AddProjectActivityView : BaseRenderableActivityView<AddProjectScreenModel>() {

    @SuppressLint("SetTextI18n")
    val beginDateDialogListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->
               val monthFromOne = month+1
                BEGIN_DATE = GregorianCalendar(year,month,day).time
                addProject_begindate_tv.text = "$day.$monthFromOne.$year"
            }
    @SuppressLint("SetTextI18n")
    val endDateDialogListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->
                val monthFromOne = month+1
                END_DATE = GregorianCalendar(year,month,day).time
                addProject_enddate_tv.text = "$day.$monthFromOne.$year"
            }

    @Inject
    lateinit var presenter: AddProjectPresenter

    var BEGIN_DATE:Date? = null
    var END_DATE:Date? = null


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

    private fun getParentFolderId():Long {
       return intent?.extras?.getLong("FOLDER_ID")!!
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_ok) {
            val projectName = addProject_projectName_ET.text.toString()
            val projectDescription = addProject_projectDescription_ET.text.toString()
            presenter.addProject(Project(0, getParentFolderId(), projectName,projectDescription,BEGIN_DATE,END_DATE))
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
        if (!screenModel.isValid()){
            addProject_projectName_ET.error = "Вы ничего не ввели"
        }
    }

    private fun initListeners() {
        beginDateTvListener()
        endDateTvListener()
    }

    private fun endDateTvListener() {
        addProject_enddate_tv.setOnClickListener {
            val endDateFragment = DatePickerDialogFragment()
            endDateFragment.setListener(endDateDialogListener)
            endDateFragment.show(supportFragmentManager, "datePicker")
        }
    }

    private fun beginDateTvListener() {
        addProject_begindate_tv.setOnClickListener {
            val beginDateFragment = DatePickerDialogFragment()
            beginDateFragment.setListener(beginDateDialogListener)
            beginDateFragment.show(supportFragmentManager, "datePicker")
        }
    }

}