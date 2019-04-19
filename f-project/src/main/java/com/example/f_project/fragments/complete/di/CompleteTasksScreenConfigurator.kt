package com.example.f_project.fragments.complete.di

import android.os.Bundle
import com.example.f_project.fragments.complete.CompleteTasksFragmentView

import dagger.Component
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.FragmentScreenConfigurator
import ru.surfstudio.standard.ui.screen.FragmentScreenModule

/**
 * Конфигуратор [CompleteTasksFragmentView].
 */
class CompleteTasksScreenConfigurator(args: Bundle?) : FragmentScreenConfigurator(args!!) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            fragmentScreenModule: FragmentScreenModule,
            args: Bundle?
    ) = DaggerCompleteTasksScreenConfigurator_CompleteTasksScreenComponent
            .builder()
            .activityComponent(parentComponent)
            .fragmentScreenModule(fragmentScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [FragmentScreenModule::class]
    )
    interface CompleteTasksScreenComponent : ScreenComponent<CompleteTasksFragmentView>
}