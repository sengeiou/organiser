package ru.surfstudio.standard.domain.folder

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Folder constructor(  @PrimaryKey(autoGenerate = true)
                                @NonNull
                                val id:Long,
                                val parentFolderId:Long,
                                val name:String) :Serializable {
}