package com.example.cf_project_recycler_view

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import ru.surfstudio.android.easyadapter.EasyAdapter
import java.util.*

class EasyAdapterWithSwipe(private val onLeftSwipeListener: (Int) -> Unit, private val onRightSwipeListener: (Int) -> Unit) : EasyAdapter(), ItemTouchHelperAdapter {
    override fun onRightSwipe(viewHolder: RecyclerView.ViewHolder, adapterPosition: Int) {
        val items = items
        items.removeAt(adapterPosition)
        setItems(items)
        onRightSwipeListener(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    override fun onLeftSwipe(viewHolder: RecyclerView.ViewHolder, adapterPosition: Int) {
        val items = items
        items.removeAt(adapterPosition)
        setItems(items)
        onLeftSwipeListener(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        val items = items
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(items, i, i - 1)
            }
        }
        setItems(items)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    private fun getitemController() {

    }
}