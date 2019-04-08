package com.example.cm_recyclerview

import android.view.ViewGroup
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

/**
 * Контроллер TODO
 */
class EmptyFolderItemController : NoDataItemController<BaseViewHolder>() {

    override fun createViewHolder(parent: ViewGroup) = BaseViewHolder(parent, R.layout.item_empty_folder)
}