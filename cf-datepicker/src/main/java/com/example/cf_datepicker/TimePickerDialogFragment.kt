package com.example.cf_datepicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerDialogFragment : DialogFragment() {
    private var listener: TimePickerDialog.OnTimeSetListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = 8
        val minute = 0
        return TimePickerDialog(activity,R.style.DatePickerTheme,listener,hour,minute,true)
    }

    fun setListener(listener: TimePickerDialog.OnTimeSetListener) {
        this.listener = listener
    }

}