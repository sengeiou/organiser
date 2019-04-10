package com.example.i_folder

import com.example.i_folder.data.FolderRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class FolderInteractorImp @Inject constructor(private val folderRepository: FolderRepository) : FolderInteractor {
    override fun loadFolderById(folderId: Long): Observable<Folder> {
        return folderRepository.getFolderById(folderId)
    }

    override fun loadFolders(parentFolderId: Long): Observable<List<Folder>> {
        return folderRepository.getFolders(parentFolderId)
    }
}