package com.example.i_folder.data

import com.example.i_database.AppDatabase
import com.example.i_database.Folder
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FolderRepositoryImp @Inject constructor(val appDatabase: AppDatabase) : FolderRepository {
    override fun addFolder(folder: ru.surfstudio.standard.domain.folder.Folder):Observable<Unit> {
      return Observable.fromCallable{appDatabase.getFolderDao().insertFolder(Folder(2,1,"asdasd")) }
                .subscribeOn(Schedulers.io())
    }
}