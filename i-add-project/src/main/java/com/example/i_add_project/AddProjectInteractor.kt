package com.example.i_add_project

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Project

interface AddProjectInteractor {
    fun addProject(project:Project):Observable<Long>
}