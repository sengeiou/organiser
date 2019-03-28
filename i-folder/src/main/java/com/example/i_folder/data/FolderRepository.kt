package com.example.i_folder.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface FolderRepository {
    fun addFolder(folder: Folder):Observable<Unit>
}