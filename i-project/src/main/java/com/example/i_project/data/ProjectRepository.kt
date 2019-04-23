package com.example.i_project.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task

interface ProjectRepository {
    fun loadTasks(projectId:Long): Observable<List<Task>>
}