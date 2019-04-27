package com.example.cf_project_recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface ItemTouchHelperAdapter {
    fun onItemMove(fromPosition: Int, toPosition: Int):Boolean
    fun onRightSwipe(viewHolder: RecyclerView.ViewHolder, adapterPosition: Int)
    fun onLeftSwipe(viewHolder: RecyclerView.ViewHolder, adapterPosition: Int)
}