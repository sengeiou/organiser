package ru.surfstudio.standard.domain.project

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Task constructor(@PrimaryKey(autoGenerate = true)
                            @NonNull
                            var id:Long,
                            var parentProjectId:Long,
                            var name:String,
                            var beginDate: Date?,
                            var endDate: Date?,
                            var reminder:Int?,
                            var repeat:Int?,
                            var isCompleted:Boolean) : Serializable {
}