package com.example.i_folder.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface FolderRepository {
    fun getFolders(parentFolderId:Long):Observable<List<Folder>>
    fun getFolderById(folderId:Long):Observable<Folder>
}