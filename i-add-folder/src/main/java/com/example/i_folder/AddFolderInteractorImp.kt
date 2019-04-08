package com.example.i_folder

import com.example.i_folder.data.AddFolderRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class AddFolderInteractorImp @Inject constructor(val folderRepository: AddFolderRepository) : AddFolderInteractor {
    override fun addFolder(folder: Folder): Observable<Unit> {
        return folderRepository.addFolder(folder)
    }


}