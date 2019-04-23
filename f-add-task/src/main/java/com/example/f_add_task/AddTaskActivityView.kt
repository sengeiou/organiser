package com.example.f_add_task

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.cf_datepicker.DatePickerDialogFragment
import com.example.cf_datepicker.TimePickerDialogFragment
import com.example.f_add_task.di.AddTaskScreenConfigurator
import kotlinx.android.synthetic.main.activity_add_task.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import java.util.*
import javax.inject.Inject

/**
 * Вью TODO
 */
class AddTaskActivityView : BaseRenderableActivityView<AddTaskScreenModel>() {
    private val datePickerDialog = DatePickerDialogFragment()
    private val timePickerDialog = TimePickerDialogFragment()

    lateinit var addTaskToolbar: Toolbar
    lateinit var beginDateTv: TextView
    lateinit var beginTimeTv: TextView
    lateinit var endDateTv: TextView
    lateinit var endTimeTv: TextView

    val beginDateDialogListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->
                val monthFromOne = month+1
                beginTimeTv.isEnabled = true
                beginTimeTv.text = "8:00"
                beginDateTv.text = "$day.$monthFromOne.$year"
            }

    val endDateDialogListener =
            DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->
                val monthFromOne = month+1
                endTimeTv.isEnabled = true
                endTimeTv.text = "8:00"
                endDateTv.text = "$day.$monthFromOne.$year"
            }

    val beginTimeDialogListener =
            TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                var minuteWithZerro:String? = null
                if(minute<10){
                    minuteWithZerro = "0$minute"
                }else minuteWithZerro = minute.toString()
                beginTimeTv.text = "$hour:$minuteWithZerro"
            }
    val endTimeDialogListener =
            TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                val minuteWithZerro:String?
                if(minute<10){
                    minuteWithZerro = "0$minute"
                }else minuteWithZerro = minute.toString()
                endTimeTv.text = "$hour:$minuteWithZerro"
            }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_ok) {

        }
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    @Inject
    lateinit var presenter: AddTaskPresenter

    override fun getScreenName() = "AddTaskActivityView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = AddTaskScreenConfigurator(intent)

    override fun getContentView(): Int = R.layout.activity_add_task

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        initToolbar()
        initViews()
        initListeners()
    }

    private fun initViews() {
        beginDateTv = add_task_begin_date_tv
        beginTimeTv = add_task_begin_time_tv
        endDateTv = add_task_end_date_tv
        endTimeTv = add_task_end_time_tv
    }

    private fun initToolbar() {
        addTaskToolbar = findViewById(R.id.add_task_toolbar)
        setSupportActionBar(addTaskToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun renderInternal(screenModel: AddTaskScreenModel) {

    }

    private fun initListeners() {
        initBeginDateListener()
        initBeginTimeListener()
        initEndDateListener()
        initEndTimeListener()
    }

    private fun initEndTimeListener() {
        endTimeTv.setOnClickListener {
            timePickerDialog.setListener(endTimeDialogListener)
            timePickerDialog.show(supportFragmentManager,"timepicker")
        }
    }

    private fun initBeginTimeListener() {
        beginTimeTv.setOnClickListener {
            timePickerDialog.setListener(beginTimeDialogListener)
            timePickerDialog.show(supportFragmentManager,"timepicker")
        }
    }

    private fun initEndDateListener() {
        beginDateTv.setOnClickListener {
            datePickerDialog.setListener(beginDateDialogListener)
            datePickerDialog.show(supportFragmentManager, "datepicker")
        }
    }

    private fun initBeginDateListener() {
        endDateTv.setOnClickListener {
            datePickerDialog.setListener(endDateDialogListener)
            datePickerDialog.show(supportFragmentManager, "datePicker")
        }
    }
}