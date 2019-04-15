package com.example.i_folder.data

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project

interface FolderRepository {
    fun getFolders(parentFolderId: Long): Observable<List<Folder>>
    fun getFolderById(folderId: Long): Observable<Folder>
    fun getProjects(parentFolderId: Long): Observable<List<Project>>
    fun getProjectById(projectId: Long):Observable<Project>
}