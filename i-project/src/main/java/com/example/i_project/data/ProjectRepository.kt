package com.example.i_project.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task

interface ProjectRepository {
    fun loadUnfinishedTasks(projectId:Long): Observable<List<Task>>
    fun loadTask(taskId:Long?):Observable<Task>
}