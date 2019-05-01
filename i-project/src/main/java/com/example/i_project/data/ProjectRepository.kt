package com.example.i_project.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task

interface ProjectRepository {
    fun loadUnfinishedTasks(projectId:Long): Observable<List<Task>>
    fun loadTask(taskId:Long?):Observable<Task>
    fun loadCompletedTasks(projectId: Long):Observable<List<Task>>
    fun completeTask(taskToComplete: Task):Observable<Int>
    fun doNotCompleteTask(taskToUnfinish:Task):Observable<Int>
    fun deleteTask(taskToDelete: Task)
}