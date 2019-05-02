package com.example.i_project.data

import android.annotation.SuppressLint
import android.util.Log
import com.example.i_database.TaskDao
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject


class ProjectRepositoryImp @Inject constructor(private val taskDao: TaskDao): ProjectRepository {
    @SuppressLint("LogNotTimber")
    override fun deleteTask(taskToDelete: Task) {
        Observable.fromCallable {taskDao.deleteTask(taskToDelete)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    Log.d(PROJECT_REPOSITORY,it.toString())
                },{
                    Log.e(PROJECT_REPOSITORY,it.message)
                })
    }

    override fun doNotCompleteTask(taskToUnfinish: Task): Observable<Int> {
      return  Observable.fromCallable { taskDao.updateTask(taskToUnfinish) }
                .subscribeOn(Schedulers.io())

    }

    private val PROJECT_REPOSITORY = "ProjectRepository"
    override fun completeTask(taskToComplete: Task): Observable<Int> {
       return Observable.fromCallable { taskDao.updateTask(taskToComplete) }
                .subscribeOn(Schedulers.io())

    }

    override fun loadCompletedTasks(projectId: Long): Observable<List<Task>> {
        return Observable.fromCallable { taskDao.getAllCompletedTasksWithParentProjectId(projectId)}
                .subscribeOn(Schedulers.io())
    }

    override fun loadTask(taskId: Long?):Observable<Task> {
        return Observable.fromCallable {taskDao.getTaskById(taskId!!)}
                .subscribeOn(Schedulers.io())
    }

    override fun loadUnfinishedTasks(projectId: Long): Observable<List<Task>> {
        return Observable.fromCallable {taskDao.getAllUnfinishedTasksWithParentProjectId(projectId)}
                .subscribeOn(Schedulers.io())
    }
}