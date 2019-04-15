package com.example.cf_internal_folder

import ru.surfstudio.android.core.mvp.model.ScreenModel
import ru.surfstudio.standard.domain.folder.Folder

///**
// * Модель [InternalFolderFragmentView].
// */
class InternalFolderScreenModel(var folderList:ArrayList<Folder> = arrayListOf(), var loading:Boolean = true) : ScreenModel() {
    fun hasContent():Boolean = folderList.isNotEmpty()
}