package com.example.cm_recyclerview.folder

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.cm_recyclerview.R
import ru.surfstudio.android.easyadapter.controller.BindableItemController
import ru.surfstudio.android.easyadapter.holder.BindableViewHolder
import ru.surfstudio.standard.domain.folder.Folder

class FolderItemController(
        private val onClickListener: (Folder) -> Unit
) : BindableItemController<Folder, FolderItemController.Holder>() {

    override fun getItemId(data: Folder): String = data.hashCode().toString()

    override fun createViewHolder(parent: ViewGroup?): Holder = Holder(parent)

    inner class Holder(
            parent: ViewGroup?
    ) : BindableViewHolder<Folder>(parent, R.layout.folder_item) {


        private lateinit var data: Folder
        private val firstTv: TextView = itemView.findViewById(R.id.projects_folderName_tv)

        init {
            itemView.findViewById<LinearLayout>(R.id.folder_data_container).apply {
                setOnClickListener { onClickListener(data) }
            }
        }

        @SuppressLint("SetTextI18n")
        override fun bind(data: Folder) {
            this.data = data
            firstTv.text = "$data"
        }
    }}