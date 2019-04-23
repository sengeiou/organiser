package com.example.i_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project
import java.util.*

@Dao
interface ProjectDao {
    @Insert
    fun insertProject(project: Project):Long
    @Query("SELECT * FROM project WHERE parentFolderId LIKE :parentFolderId")
    fun getAllProjectsWithParentFolderId(parentFolderId: Long): List<Project>

    @Query("SELECT * FROM project WHERE id LIKE :projectId")
    fun getProjectById(projectId: Long): Project

    @Query("SELECT * FROM project")
    fun getAllProjects(): List<Project>
}