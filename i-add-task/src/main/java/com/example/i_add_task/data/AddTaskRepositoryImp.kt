package com.example.i_add_task.data

import com.example.i_database.TaskDao
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject

class AddTaskRepositoryImp @Inject constructor(private val taskDao: TaskDao): AddTaskRepository {
    override fun addTask(task: Task): Observable<Long> {
        return Observable.fromCallable {taskDao.insertTask(task)}
                .subscribeOn(Schedulers.io())
    }
}