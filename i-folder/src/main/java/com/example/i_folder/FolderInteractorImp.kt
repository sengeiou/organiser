package com.example.i_folder

import com.example.i_folder.data.FolderRepository
import io.reactivex.Observable
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project
import javax.inject.Inject

class FolderInteractorImp @Inject constructor(private val folderRepository: FolderRepository) : FolderInteractor {
    override fun loadProjectById(projectId: Long): Observable<Project> {
        return folderRepository.getProjectById(projectId)
    }

    override fun loadProjects(parentFolderId: Long): Observable<List<Project>> {
        return folderRepository.getProjects(parentFolderId)
    }

    override fun loadFolderById(folderId: Long): Observable<Folder> {
        return folderRepository.getFolderById(folderId)
    }

    override fun loadFolders(parentFolderId: Long): Observable<List<Folder>> {
        return folderRepository.getFolders(parentFolderId)
    }
}