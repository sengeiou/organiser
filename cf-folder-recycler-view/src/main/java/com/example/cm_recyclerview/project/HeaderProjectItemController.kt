package com.example.cm_recyclerview.project

import android.view.ViewGroup
import com.example.cm_recyclerview.R
import ru.surfstudio.android.easyadapter.controller.NoDataItemController
import ru.surfstudio.android.easyadapter.holder.BaseViewHolder

/**
 * Контроллер TODO
 */
class HeaderProjectItemController : NoDataItemController<BaseViewHolder>() {

    override fun createViewHolder(parent: ViewGroup) = BaseViewHolder(parent, R.layout.item_project_header)
}