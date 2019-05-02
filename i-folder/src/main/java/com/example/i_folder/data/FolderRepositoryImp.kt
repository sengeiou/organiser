package com.example.i_folder.data

import com.example.i_database.FolderDao
import com.example.i_database.ProjectDao
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project
import javax.inject.Inject

class FolderRepositoryImp @Inject constructor(private val folderDao: FolderDao,
                                              private val projectDao: ProjectDao) : FolderRepository {
    override fun getProjectById(projectId: Long): Observable<Project> {
        return Observable.fromCallable { projectDao.getProjectById(projectId) }
                .subscribeOn(Schedulers.io())
    }

    override fun getProjects(parentFolderId: Long): Observable<List<Project>> {
        return Observable.fromCallable { projectDao.getAllProjectsWithParentFolderId(parentFolderId) }
                .subscribeOn(Schedulers.io())
    }

    override fun getFolderById(folderId: Long): Observable<Folder> {
        return Observable.fromCallable { folderDao.getFolderById(folderId) }
                .subscribeOn(Schedulers.io())
    }

    override fun getFolders(parentFolderId: Long): Observable<List<Folder>> {
        return Observable.fromCallable { folderDao.getAllFoldersWithParentId(parentFolderId) }
                .subscribeOn(Schedulers.io())
    }
}