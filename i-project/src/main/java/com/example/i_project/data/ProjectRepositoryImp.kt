package com.example.i_project.data

import com.example.i_database.TaskDao
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject


class ProjectRepositoryImp @Inject constructor(val taskDao: TaskDao): ProjectRepository {

    override fun loadTasks(projectId: Long): Observable<List<Task>> {
        return Observable.fromCallable {taskDao.getAllTasksWithParentProjectId(projectId)}
                .subscribeOn(Schedulers.io())
    }
}