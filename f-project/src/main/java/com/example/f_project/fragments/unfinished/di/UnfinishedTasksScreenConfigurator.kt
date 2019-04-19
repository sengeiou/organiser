package com.example.f_project.fragments.unfinished.di

import android.os.Bundle
import com.example.f_project.fragments.unfinished.UnfinishedTasksFragmentView

import dagger.Component
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.FragmentScreenConfigurator
import ru.surfstudio.standard.ui.screen.FragmentScreenModule

/**
 * Конфигуратор [UnfinishedTasksFragmentView].
 */
class UnfinishedTasksScreenConfigurator(args: Bundle?) : FragmentScreenConfigurator(args!!) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            fragmentScreenModule: FragmentScreenModule,
            args: Bundle?
    ) = DaggerUnfinishedTasksScreenConfigurator_UnfinishedTasksScreenComponent
            .builder()
            .activityComponent(parentComponent)
            .fragmentScreenModule(fragmentScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [FragmentScreenModule::class]
    )
    interface UnfinishedTasksScreenComponent : ScreenComponent<UnfinishedTasksFragmentView>
}