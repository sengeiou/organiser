package com.example.cm_main_folder

import ru.surfstudio.android.core.mvp.model.LdsScreenModel
import ru.surfstudio.android.core.mvp.model.ScreenModel
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.standard.domain.folder.Folder

/**
 * Модель [ProjectsListFragmentView].
 */
data class MainFolderScreenModel(var folderList:List<Folder> = listOf(), val loading:Boolean = true) : LdsScreenModel() {

    class Loading()
    fun hasContent():Boolean = folderList.isNotEmpty()
}