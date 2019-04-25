package com.example.cf_project_recycler_view

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import ru.surfstudio.android.easyadapter.EasyAdapter
import ru.surfstudio.android.easyadapter.item.BaseItem
import ru.surfstudio.android.easyadapter.item.BindableItem

class EasyAdapterWithSwipe:EasyAdapter(),ItemTouchHelperAdapter{
    override fun onItemMove(fromPosition: View, toPosition: Int) {

    }

    private fun getitemController(){

    }
    override fun onItemDismiss(item: RecyclerView.ViewHolder, position: Int) {
        Log.d("ITEMDISMISS","DISMISS $position")
        //TODO Сделать удаление элемента
        items.removeAt(2)
        Log.d("ITEMDISMISS","DISMISS $items")
        notifyItemRemoved(position)
    }


}