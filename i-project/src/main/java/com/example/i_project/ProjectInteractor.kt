package com.example.i_project

import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task

interface ProjectInteractor {
    fun loadTasks(projectId:Long):Observable<List<Task>>
}