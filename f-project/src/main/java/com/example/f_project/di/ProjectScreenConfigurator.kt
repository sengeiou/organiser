package com.example.f_project.di

import android.content.Intent
import com.example.f_project.ProjectActivityView

import dagger.Component
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.ActivityScreenConfigurator
import ru.surfstudio.standard.ui.screen.ActivityScreenModule

/**
 * Конфигуратор [ProjectActivityView].
 */
class ProjectScreenConfigurator(intent: Intent) : ActivityScreenConfigurator(intent) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            activityScreenModule: ActivityScreenModule,
            intent: Intent
    ) = DaggerProjectScreenConfigurator_ProjectScreenComponent.builder()
            .activityComponent(parentComponent)
            .activityScreenModule(activityScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [ActivityScreenModule::class]
    )
    interface ProjectScreenComponent : ScreenComponent<ProjectActivityView>
}