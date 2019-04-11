package com.example.f_add_project.di

import android.content.Intent
import com.example.f_add_project.AddProjectActivityView
import com.example.i_add_project.AddProjectInteractor
import com.example.i_add_project.AddProjectInteractorImp
import com.example.i_add_project.data.AddProjectRepository
import com.example.i_add_project.data.AddProjectRepositoryImp
import dagger.Binds

import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.ActivityScreenConfigurator
import ru.surfstudio.standard.ui.screen.ActivityScreenModule

/**
 * Конфигуратор [AddProjectActivityView].
 */
class AddProjectScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            activityScreenModule: ActivityScreenModule,
            intent: Intent
    ) = DaggerAddProjectScreenConfigurator_AddProjectScreenComponent
            .builder()
            .activityComponent(parentComponent)
            .activityScreenModule(activityScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class,AddProjectScreenModule::class]
    )
    interface AddProjectScreenComponent : ScreenComponent<AddProjectActivityView>

    @Module
    interface AddProjectScreenModule{
        @Binds
        @PerScreen
        fun provideAddProjectRepository(addProjectRepositoryImp: AddProjectRepositoryImp):AddProjectRepository

        @Binds
        @PerScreen
        fun provideAddProjectInteractor(addProjectInteractorImp: AddProjectInteractorImp):AddProjectInteractor
    }
}