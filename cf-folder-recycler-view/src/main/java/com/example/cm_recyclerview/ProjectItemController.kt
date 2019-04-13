package com.example.cm_recyclerview

import android.view.ViewGroup
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.standard.domain.folder.Project

/**
 * Контроллер TODO
 */
class ProjectItemController(
        private val onItemClickAction: (Project) -> Unit
) : BindableItemController<Project, ProjectItemController.Holder>() {

    override fun createViewHolder(parent: ViewGroup) = Holder(parent)

    override fun getItemId(project: Project) = TODO()

    inner class Holder(parent: ViewGroup) : BindableViewHolder<Project>(parent, R.layout.item_project) {

        private lateinit var project: Project

        init {
            itemView.setOnClickListener { onItemClickAction(project) }
        }

        override fun bind(project: Project) {
            this.project = project

        }
    }
}