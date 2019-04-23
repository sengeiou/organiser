package com.example.f_add_task.di

import android.content.Intent
import com.example.f_add_task.AddTaskActivityView

import dagger.Component
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

    //создать модуль который провайдит классы i-add-task мудуля TODO
    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class]
    )
    interface AddTaskScreenComponent : ScreenComponent<AddTaskActivityView>
}