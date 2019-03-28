package com.example.i_folder

import com.example.i_folder.data.FolderRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class FolderInteractorImp @Inject constructor(val folderRepository: FolderRepository) : FolderInteractor {
    override fun addFolder(folder: Folder): Observable<Unit> {
        return folderRepository.addFolder(folder)
    }


}