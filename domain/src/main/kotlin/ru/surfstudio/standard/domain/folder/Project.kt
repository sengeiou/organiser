package ru.surfstudio.standard.domain.folder

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Project constructor(  @PrimaryKey(autoGenerate = true)
                                 @NonNull
                                 val id:Long,
                                 val parentFolderId:Long,
                                 val name:String) : Serializable {
}