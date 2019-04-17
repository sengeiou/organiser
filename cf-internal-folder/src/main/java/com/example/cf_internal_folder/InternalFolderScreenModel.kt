package com.example.cf_internal_folder

import ru.surfstudio.android.core.mvp.model.ScreenModel
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project

///**
// * Модель [InternalFolderFragmentView].
// */
class InternalFolderScreenModel(var folderList:ArrayList<Folder> = arrayListOf(),
                                var projectList:ArrayList<Project> = arrayListOf(),
                                var loading:Boolean = true) : ScreenModel() {
    fun hasContent():Boolean = folderList.isNotEmpty() || projectList.isNotEmpty()
    fun hasFolders():Boolean = folderList.isNotEmpty()
    fun hasProjects():Boolean = projectList.isNotEmpty()
}