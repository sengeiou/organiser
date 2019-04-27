package com.example.cm_recyclerview.folder

import android.view.ViewGroup
import com.example.cm_recyclerview.R
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

/**
 * Контроллер
 */
class EmptyFolderItemController : NoDataItemController<BaseViewHolder>() {

    override fun createViewHolder(parent: ViewGroup) = BaseViewHolder(parent, R.layout.item_empty_folder)
}