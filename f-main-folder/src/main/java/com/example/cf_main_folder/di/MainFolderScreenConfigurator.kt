package com.example.cf_main_folder.di

import android.os.Bundle
import com.example.cf_main_folder.MainFolderFragmentView
import com.example.i_folder.FolderInteractor
import com.example.i_folder.FolderInteractorImp
import com.example.i_folder.data.FolderRepository
import com.example.i_folder.data.FolderRepositoryImp
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.FragmentScreenConfigurator
import ru.surfstudio.standard.ui.screen.FragmentScreenModule

/**
 * Конфигуратор [ProjectsListFragmentView].
 */
class MainFolderScreenConfigurator(args: Bundle?) : FragmentScreenConfigurator(args!!) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            fragmentScreenModule: FragmentScreenModule,
            args: Bundle?
    ) = DaggerMainFolderScreenConfigurator_MainFolderScreenComponent
            .builder()
            .activityComponent(parentComponent)
            .fragmentScreenModule(fragmentScreenModule)
            .build()


    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [FragmentScreenModule::class,MainFolderScreenModule::class]
    )
    interface MainFolderScreenComponent : ScreenComponent<MainFolderFragmentView>

    @Module
    interface MainFolderScreenModule{

        @Binds
        @PerScreen
        fun provideFolderInteractor(folderInteractorImp: FolderInteractorImp):FolderInteractor

        @Binds
        @PerScreen
        fun provideFolderRepository(folderRepositoryImp: FolderRepositoryImp):FolderRepository
    }
}