package com.example.i_add_task

import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task

interface AddTaskInteractor {
    fun addTask(task: Task): Observable<Long>
}