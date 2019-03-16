package ru.surfstudio.standard.f_main.projects.di

import android.os.Bundle

import dagger.Component
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.f_main.projects.ProjectsListFragmentView
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.FragmentScreenConfigurator
import ru.surfstudio.standard.ui.screen.FragmentScreenModule

/**
 * Конфигуратор [ProjectsListFragmentView].
 */
class ProjectsListScreenConfigurator(args: Bundle?) : FragmentScreenConfigurator(args!!) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            fragmentScreenModule: FragmentScreenModule,
            args: Bundle?
    ) = DaggerProjectsListScreenConfigurator_ProjectsListScreenComponent
            .builder()
            .activityComponent(parentComponent)
            .fragmentScreenModule(fragmentScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [FragmentScreenModule::class]
    )
    interface ProjectsListScreenComponent : ScreenComponent<ProjectsListFragmentView>
}