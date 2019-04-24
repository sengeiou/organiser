package com.example.cf_project_recycler_view

import android.view.ViewGroup
import android.widget.TextView
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.standard.domain.project.Task

/**
 * Контроллер
 */
class TaskItemController(
        private val onItemClickAction: (Task) -> Unit
) : BindableItemController<Task, TaskItemController.Holder>() {

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    override fun getItemId(task: Task) = task.hashCode().toString()

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Task>(parent, R.layout.item_task) {

        private lateinit var task: Task
        private val taskName = itemView.findViewById<TextView>(R.id.task_name)
        private val taskDate = itemView.findViewById<TextView>(R.id.task_date)

        //TODO Сделать отображение даты
        init {
            itemView.setOnClickListener { onItemClickAction(task) }
        }

        override fun bind(task: Task) {
            this.task = task
            taskName.text = task.name
        }
    }
}