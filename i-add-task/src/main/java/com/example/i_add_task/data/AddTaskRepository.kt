package com.example.i_add_task.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task

interface AddTaskRepository {
    fun addTask(task:Task):Observable<Long>
}