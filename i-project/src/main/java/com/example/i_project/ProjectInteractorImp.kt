package com.example.i_project

import com.example.i_project.data.ProjectRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.project.Task
import javax.inject.Inject

class ProjectInteractorImp @Inject constructor(private val projectRepository: ProjectRepository):ProjectInteractor {
    override fun loadTasks(projectId: Long): Observable<List<Task>> {
        return  projectRepository.loadTasks(projectId)
    }
}