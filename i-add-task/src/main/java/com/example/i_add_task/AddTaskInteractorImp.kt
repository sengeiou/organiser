package com.example.i_add_task

import com.example.i_add_task.data.AddTaskRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject

class AddTaskInteractorImp @Inject constructor(private val addTaskRepository: AddTaskRepository):AddTaskInteractor {
    override fun addTask(task: Task): Observable<Long> {
        return addTaskRepository.addTask(task)
    }
}