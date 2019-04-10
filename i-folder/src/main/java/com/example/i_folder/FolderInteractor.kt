package com.example.i_folder

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface FolderInteractor {
    fun loadFolders(parentFolderId:Long):Observable<List<Folder>>
    fun loadFolderById(folderId:Long):Observable<Folder>
}