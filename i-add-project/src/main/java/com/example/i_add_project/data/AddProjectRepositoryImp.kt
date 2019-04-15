package com.example.i_add_project.data

import android.util.Log
import com.example.i_database.ProjectDao
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.folder.Project
import java.text.SimpleDateFormat
import javax.inject.Inject

class AddProjectRepositoryImp @Inject constructor(val projectDao: ProjectDao) : AddProjectRepository {
    override fun addProject(project: Project): Observable<Long> {
        return Observable.fromCallable { projectDao.insertProject(project)}
                .subscribeOn(Schedulers.io())

    }
}