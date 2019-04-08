package com.example.i_folder.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface FolderRepository {
    fun getFolders(parentFolderId:Int):Observable<List<Folder>>
}