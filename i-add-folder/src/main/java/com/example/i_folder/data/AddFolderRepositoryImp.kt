package com.example.i_folder.data

import android.util.Log
import com.example.i_database.AppDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject

class AddFolderRepositoryImp @Inject constructor(val appDatabase: AppDatabase) : AddFolderRepository {
    override fun addFolder(folder: Folder):Observable<Unit> {


      return Observable.fromCallable{appDatabase.getFolderDao().insertFolder(folder) }
                .subscribeOn(Schedulers.io())
    }
}