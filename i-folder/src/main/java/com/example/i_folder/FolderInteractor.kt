package com.example.i_folder

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface FolderInteractor {
    fun loadFolders(parentFolderId:Int):Observable<List<Folder>>
}