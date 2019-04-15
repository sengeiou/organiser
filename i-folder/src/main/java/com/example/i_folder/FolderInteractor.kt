package com.example.i_folder

import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project

interface FolderInteractor {
    fun loadFolders(parentFolderId:Long):Observable<List<Folder>>
    fun loadFolderById(folderId:Long):Observable<Folder>
    fun loadProjects(parentFolderId: Long):Observable<List<Project>>
    fun loadProjectById(projectId:Long):Observable<Project>
}