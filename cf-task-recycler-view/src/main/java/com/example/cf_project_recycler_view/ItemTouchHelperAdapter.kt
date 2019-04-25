package com.example.cf_project_recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: View, toPosition: Int)

    fun onItemDismiss(item: RecyclerView.ViewHolder,position:Int)
}