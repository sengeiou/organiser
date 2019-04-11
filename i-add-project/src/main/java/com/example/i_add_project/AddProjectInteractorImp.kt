package com.example.i_add_project

import com.example.i_add_project.data.AddProjectRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Project
import javax.inject.Inject

class AddProjectInteractorImp  @Inject constructor(val addProjectRepository: AddProjectRepository):AddProjectInteractor {
    override fun addProject(project: Project): Observable<Long> {
        return addProjectRepository.addProject(project)
    }
}