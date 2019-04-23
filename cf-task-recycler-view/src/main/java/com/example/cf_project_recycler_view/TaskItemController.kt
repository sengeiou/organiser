package com.example.cf_project_recycler_view

import android.view.ViewGroup
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

/**
 * Контроллер
 */
class TaskItemController(
        private val onItemClickAction: () -> Unit
) : NoDataItemController<TaskItemController.Holder>() {

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    inner class Holder(parent: ViewGroup) : BaseViewHolder(parent, R.layout.item_task) {

        init {
            itemView.setOnClickListener { onItemClickAction() }
        }
    }
}