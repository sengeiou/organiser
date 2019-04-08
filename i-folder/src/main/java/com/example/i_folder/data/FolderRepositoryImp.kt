package com.example.i_folder.data

import com.example.i_database.AppDatabase
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class FolderRepositoryImp @Inject constructor(private val appDatabase: AppDatabase) : FolderRepository {
    override fun getFolders(parentFolderId: Int): Observable<List<Folder>> {
       return Observable.fromCallable { appDatabase.getFolderDao().getAllFoldersWithParentId(parentFolderId) }
                .subscribeOn(Schedulers.io())
    }
}