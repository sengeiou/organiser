package com.example.i_folder

import android.util.Log
import com.example.i_folder.data.FolderRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class FolderInteractorImp @Inject constructor(private val folderRepository: FolderRepository) : FolderInteractor {
    override fun loadFolders(parentFolderId: Int): Observable<List<Folder>> {
      return folderRepository.getFolders(parentFolderId)
    }
}