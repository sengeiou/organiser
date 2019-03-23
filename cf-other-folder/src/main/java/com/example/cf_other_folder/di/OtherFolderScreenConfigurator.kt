package com.example.cf_other_folder.di

import android.os.Bundle
import com.example.cf_other_folder.OtherFolderFragmentView
import dagger.Component
import ru.surfstudio.android.core.mvp.configurator.ScreenComponent
import ru.surfstudio.android.dagger.scope.PerScreen
import ru.surfstudio.standard.ui.activity.di.ActivityComponent
import ru.surfstudio.standard.ui.activity.di.FragmentScreenConfigurator
import ru.surfstudio.standard.ui.screen.FragmentScreenModule

//**
// * Конфигуратор [OtherFolderFragmentView].
// */
class OtherFolderScreenConfigurator(args: Bundle?) : FragmentScreenConfigurator(args!!) {

    override fun createScreenComponent(
            parentComponent: ActivityComponent,
            fragmentScreenModule: FragmentScreenModule,
            args: Bundle?
    ) = DaggerOtherFolderScreenConfigurator_OtherFolerScreenComponent.builder()
            .activityComponent(parentComponent)
            .fragmentScreenModule(fragmentScreenModule)
            .build()

    @PerScreen
    @Component(
            dependencies = [ActivityComponent::class],
            modules = [FragmentScreenModule::class]
    )
    interface OtherFolerScreenComponent : ScreenComponent<OtherFolderFragmentView>
}