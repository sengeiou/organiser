package ru.surfstudio.standard.ui.navigation

import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureRoute
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureWithParamsRoute

/**
 * Роут главного экрана
 */
class MainActivityRoute :ActivityCrossFeatureRoute() {

    override fun targetClassPath(): String {
        return "ru.surfstudio.standard.f_main.main.MainActivityView"
    }
}