package com.example.f_add_task.di

import android.content.Intent
import com.example.f_add_task.AddTaskActivityView
import com.example.i_add_task.AddTaskInteractor
import com.example.i_add_task.AddTaskInteractorImp
import com.example.i_add_task.data.AddTaskRepository
import com.example.i_add_task.data.AddTaskRepositoryImp
import dagger.Binds

import dagger.Component
import dagger.Module
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.ActivityScreenConfigurator
import ru.surfstudio.standard.ui.screen.ActivityScreenModule

/**
 * Конфигуратор [AddTaskActivityView].
 */
class AddTaskScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            activityScreenModule: ActivityScreenModule,
            intent: Intent
    ) = DaggerAddTaskScreenConfigurator_AddTaskScreenComponent
            .builder()
            .activityComponent(parentComponent)
            .activityScreenModule(activityScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class,AddTaskScreenModule::class]
    )
    interface AddTaskScreenComponent : ScreenComponent<AddTaskActivityView>

    @Module
    interface AddTaskScreenModule{
        @Binds
        @PerScreen
        fun provideAddTaskRepository(addTaskRepositoryImp: AddTaskRepositoryImp):AddTaskRepository

        @Binds
        @PerScreen
        fun provideAddTaskInteractor(addTaskInteractorImp: AddTaskInteractorImp):AddTaskInteractor
    }
}