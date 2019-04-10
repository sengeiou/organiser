package com.example.i_folder.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface AddFolderRepository {
    fun addFolder(folder: Folder):Observable<Long>?
}