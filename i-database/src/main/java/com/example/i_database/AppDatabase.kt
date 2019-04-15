package com.example.i_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.domain.folder.Project
import java.util.concurrent.Executors


@Database(entities = arrayOf(Folder::class, Project::class), version = 7,exportSchema = false)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getFolderDao(): FolderDao
    abstract fun getProjectDao(): ProjectDao

    companion object {

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            var INSTANCE: AppDatabase? = null

            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context)
            }
            return INSTANCE
        }

        //Создание главной папки приложения(для того чтобы в дальнейшем не было id с номером 1 у других папок)
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context,
                    AppDatabase::class.java,
                    "app-database")
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Executors.newSingleThreadScheduledExecutor()
                                    .execute {
                                        getInstance(context)
                                                .getFolderDao()
                                                .insertFolder(Folder(0, 0, "Главная папка"))
                                    }
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()

        }
    }

}