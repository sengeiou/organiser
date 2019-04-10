package com.example.i_folder.data

import com.example.i_database.AppDatabase
import com.example.i_database.FolderDao
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class FolderRepositoryImp @Inject constructor(private val folderDao: FolderDao) : FolderRepository {
    override fun getFolderById(folderId: Long): Observable<Folder> {
      return Observable.fromCallable { folderDao.getFolderById(folderId) }
              .subscribeOn(Schedulers.io())
    }

    override fun getFolders(parentFolderId: Long): Observable<List<Folder>> {
       return Observable.fromCallable { folderDao.getAllFoldersWithParentId(parentFolderId) }
                .subscribeOn(Schedulers.io())
    }
}