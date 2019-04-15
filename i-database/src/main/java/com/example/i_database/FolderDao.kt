package com.example.i_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.surfstudio.standard.domain.folder.Folder
import java.util.*

@Dao
interface FolderDao {
    @Insert
    fun insertFolder(folder:Folder):Long

    //получить список папок в папке
    @Query("SELECT * FROM folder WHERE parentFolderId LIKE :parentFolderId")
    fun getAllFoldersWithParentId(parentFolderId: Long): List<Folder>

    @Query("SELECT * FROM folder WHERE id LIKE :folderId")
    fun getFolderById(folderId: Long): Folder

    @Query("SELECT * FROM folder")
    fun getAllFolder(): List<Folder>


}