package ru.surfstudio.standard.application.app.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.connection.ConnectionProvider
import ru.surfstudio.android.activity.holder.ActiveActivityHolder
import ru.surfstudio.standard.base.util.StringsProvider
import ru.surfstudio.android.core.ui.navigation.activity.navigator.GlobalNavigator
import ru.surfstudio.android.dagger.scope.PerApplication
import ru.surfstudio.android.rx.extension.scheduler.SchedulersProvider
import ru.surfstudio.android.rx.extension.scheduler.SchedulersProviderImpl
import com.example.i_database.AppDatabase
import androidx.room.Room
import com.example.i_database.FolderDao
import com.example.i_database.ProjectDao
import com.example.i_database.TaskDao
import ru.surfstudio.standard.domain.folder.Folder


@Module
class AppModule(
        private val app: Application,
        private val activeActivityHolder: ActiveActivityHolder
) {

    @Provides
    @PerApplication
    internal fun provideActiveActivityHolder(): ActiveActivityHolder = activeActivityHolder

    @Provides
    @PerApplication
    internal fun provideContext(): Context = app

    @Provides
    @PerApplication
    internal fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @PerApplication
    internal fun provideFolderDao(appDatabase: AppDatabase): FolderDao = appDatabase.getFolderDao()

    @Provides
    @PerApplication
    internal fun provideProjectDao(appDatabase: AppDatabase): ProjectDao = appDatabase.getProjectDao()

    @Provides
    @PerApplication
    internal fun provideTaskDao(appDatabase: AppDatabase): TaskDao = appDatabase.getTaskDao()

    @Provides
    @PerApplication
    internal fun provideApp(): Application = app

    @Provides
    @PerApplication
    internal fun provideStringsProvider(context: Context): StringsProvider = StringsProvider(context)

    @Provides
    @PerApplication
    internal fun provideGlobalNavigator(
            context: Context,
            activityHolder: ActiveActivityHolder
    ): GlobalNavigator {
        return GlobalNavigator(context, activityHolder)
    }

    @Provides
    @PerApplication
    internal fun provideSchedulerProvider(): SchedulersProvider = SchedulersProviderImpl()


    @Provides
    @PerApplication
    internal fun provideConnectionQualityProvider(context: Context): ConnectionProvider {
        return ConnectionProvider(context)
    }
}