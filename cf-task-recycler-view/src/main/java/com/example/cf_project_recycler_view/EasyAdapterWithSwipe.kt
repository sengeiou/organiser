package com.example.cf_project_recycler_view

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.project.Task

class EasyAdapterWithSwipe(private val onLeftSwipeListener: (Int) -> Unit) : EasyAdapter(), ItemTouchHelperAdapter {
    override fun onItemMove(fromPosition: View, toPosition: Int) {

    }

    private fun getitemController() {

    }

    override fun onItemDismiss(item: RecyclerView.ViewHolder, position: Int) {
        val items = items
        items.removeAt(position)
        setItems(items)
        onLeftSwipeListener(position)
        notifyItemRemoved(position)
    }


}