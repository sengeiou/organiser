package com.example.i_project

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import ru.surfstudio.standard.domain.project.Task

interface ProjectInteractor {
    fun loadUnfinishedTasks(projectId: Long): Observable<List<Task>>
    fun loadTask(taskId: Long?): Observable<Task>
    fun completeTask(taskToComplete: Task)
    fun subscribeToCompleteTask(): PublishSubject<Task>
    fun subscribeToUnfinishedTask(): PublishSubject<Task>
    fun subscribeToUpdateTasks(): PublishSubject<Boolean>
    fun loadCompletedTasks(projectId: Long): Observable<List<Task>>
    fun doNotCompleteTask(taskToUnfinish: Task)
    fun deleteTask(taskToDelete: Task)
    fun calculateProjectsProgress(projectId: Long): Observable<Int>?
}