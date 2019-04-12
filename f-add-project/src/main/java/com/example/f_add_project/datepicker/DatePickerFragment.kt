package com.example.f_add_project.datepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.f_add_project.R
import java.util.*

class DatePickerFragment : DialogFragment() {
    private var listener: DatePickerDialog.OnDateSetListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity,R.style.DatePickerTheme, listener, year, month, day)
    }

    fun setListener(listener: DatePickerDialog.OnDateSetListener) {
        this.listener = listener
    }

}