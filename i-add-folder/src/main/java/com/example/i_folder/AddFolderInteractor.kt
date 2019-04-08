package com.example.i_folder

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder

interface AddFolderInteractor {
    fun addFolder(folder: Folder):Observable<Unit>
}