package com.example.f_add_folder.di

import android.content.Intent
import com.example.f_add_folder.AddFolderActivityView
import com.example.i_folder.AddFolderInteractor
import com.example.i_folder.AddFolderInteractorImp
import com.example.i_folder.data.AddFolderRepository
import com.example.i_folder.data.AddFolderRepositoryImp
import dagger.Binds

import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.ActivityScreenConfigurator
import ru.surfstudio.standard.ui.screen.ActivityScreenModule

/**
 * Конфигуратор [AddFolderActivityView].
 */
class AddFolderScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            activityScreenModule: ActivityScreenModule,
            intent: Intent
    ) = DaggerAddFolderScreenConfigurator_AddFolderScreenComponent.builder()
            .activityComponent(parentComponent)
            .activityScreenModule(activityScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class,AddFolderScreenModule::class]
    )
    interface AddFolderScreenComponent : ScreenComponent<AddFolderActivityView>

    @Module
    interface AddFolderScreenModule{
        @Binds
        @PerScreen
        fun provideFolderInteractor(folderInteractorImp: AddFolderInteractorImp):AddFolderInteractor

        @Binds
        @PerScreen
        fun provideFolderRepository(folderRepositoryImp: AddFolderRepositoryImp):AddFolderRepository

    }
}