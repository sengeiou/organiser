package ru.surfstudio.standard.application.app.di

import android.content.Context
import android.content.SharedPreferences
import com.example.i_database.AppDatabase
import com.example.i_database.FolderDao
import com.example.i_database.ProjectDao
import com.example.i_database.TaskDao
import com.example.i_project.ProjectInteractor
import com.example.i_project.data.ProjectRepository
import ru.surfstudio.android.activity.holder.ActiveActivityHolder
import ru.surfstudio.android.connection.ConnectionProvider
import ru.surfstudio.android.core.ui.navigation.activity.navigator.GlobalNavigator
import ru.surfstudio.android.dagger.scope.PerApplication
import ru.surfstudio.android.notification.PushHandler
import ru.surfstudio.android.rx.extension.scheduler.SchedulersProvider
import ru.surfstudio.android.shared.pref.NO_BACKUP_SHARED_PREF
import ru.surfstudio.standard.base.util.StringsProvider
import ru.surfstudio.standard.i_initialization.InitializeAppInteractor
import ru.surfstudio.standard.i_push_notification.storage.FcmStorage
import ru.surfstudio.standard.i_session.SessionChangedInteractor
import javax.inject.Named

/**
 * Интерфейс, объединяющий в себе все зависимости в скоупе [PerApplication]
 * Следует использовать в компоненте Application и других компонентах более высоких уровней,
 * зависящих от него.
 */
interface AppProxyDependencies {
    fun initializeAppInteractor(): InitializeAppInteractor
    fun context(): Context
    fun activeActivityHolder(): ActiveActivityHolder
    fun connectionProvider(): ConnectionProvider
    fun sessionChangedInteractor(): SessionChangedInteractor
    fun schedulerProvider(): SchedulersProvider
    fun stringsProvider(): StringsProvider
    fun globalNavigator(): GlobalNavigator
    fun appDatabase(): AppDatabase
    fun folderDao(): FolderDao
    fun projectDao(): ProjectDao
    fun taskDao(): TaskDao
    fun projectInteractor():ProjectInteractor
    fun projectRepository():ProjectRepository


    fun fcmStorage(): FcmStorage
    fun pushHandler(): PushHandler

    @Named(NO_BACKUP_SHARED_PREF)
    fun sharedPreferences(): SharedPreferences
}