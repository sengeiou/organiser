package ru.surfstudio.standard.domain.folder

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Project(@PrimaryKey(autoGenerate = true)
                   @NonNull
                   var id: Long,
                   var parentFolderId: Long,
                   var name: String,
                   var beginDate: Date,
                   var endDate: Date
) : Serializable {

}