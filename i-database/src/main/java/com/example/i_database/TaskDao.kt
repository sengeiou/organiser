package com.example.i_database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.surfstudio.standard.domain.folder.Project
import ru.surfstudio.standard.domain.project.Task

@Dao
interface TaskDao {
    @Insert
    fun insertTask(task: Task):Long

    @Update
    fun updateTask(task: Task):Int

    @Query("SELECT * FROM task WHERE parentProjectId LIKE :parentProjectId AND isCompleted LIKE :isCompleted")
    fun getAllUnfinishedTasksWithParentProjectId(parentProjectId: Long,isCompleted:Boolean = false): List<Task>

    @Query("SELECT * FROM task WHERE parentProjectId LIKE :parentProjectId AND isCompleted LIKE :isCompleted")
    fun getAllCompletedTasksWithParentProjectId(parentProjectId: Long,isCompleted:Boolean = true): List<Task>

    @Query("SELECT * FROM task WHERE id LIKE :taskId")
    fun getTaskById(taskId: Long): Task

    @Query("SELECT * FROM task")
    fun getAllTasks(): List<Task>
}