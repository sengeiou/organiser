package ru.surfstudio.standard.f_main.projects.controllers

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.android.template.f_main.R


class FolderItemController(
        private val onClickListener: () -> Unit
) : BindableItemController<String, FolderItemController.Holder>() {

    override fun getItemId(data: String): String = data.hashCode().toString()

    override fun createViewHolder(parent: ViewGroup?): FolderItemController.Holder = Holder(parent)

    inner class Holder(
            parent: ViewGroup?
    ) : BindableViewHolder<String>(parent, R.layout.folder_item) {


        private lateinit var data: String
        private val firstTv: TextView = itemView.findViewById(R.id.projects_folderName_tv)

        init {
            itemView.findViewById<LinearLayout>(R.id.folder_data_container).apply {
                setOnClickListener { onClickListener() }
            }
        }

        @SuppressLint("SetTextI18n")
        override fun bind(data: String) {
            this.data = data
            firstTv.text = "$data"
        }
    }}