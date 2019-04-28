package com.example.i_project

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import ru.surfstudio.standard.domain.project.Task

interface ProjectInteractor {
    fun loadUnfinishedTasks(projectId:Long):Observable<List<Task>>
    fun loadTask(taskId: Long?):Observable<Task>
    fun completeTask(taskToComplete: Task)
    fun subscribeToCompleteTask():PublishSubject<Task>
}