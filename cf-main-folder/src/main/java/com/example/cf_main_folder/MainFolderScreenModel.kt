package com.example.cf_main_folder

import ru.surfstudio.android.core.mvp.model.LdsScreenModel
import ru.surfstudio.android.core.mvp.model.ScreenModel
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project

/**
 * Модель [ProjectsListFragmentView].
 */
data class MainFolderScreenModel(var folderList:ArrayList<Folder> = arrayListOf(),
                                 var projectList:ArrayList<Project> = arrayListOf(),
                                 var loading:Boolean = true) : ScreenModel() {

    fun hasContent():Boolean = folderList.isNotEmpty() || projectList.isNotEmpty()
}