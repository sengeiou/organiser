package com.example.i_add_project.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Project

interface AddProjectRepository {
    fun addProject(project: Project):Observable<Long>
}