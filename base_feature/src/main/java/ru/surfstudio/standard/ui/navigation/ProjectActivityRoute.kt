package ru.surfstudio.standard.ui.navigation

import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureRoute
import ru.surfstudio.standard.ui.navigation.FeatureRoute.FragmentCrossFeatureRoute

class ProjectActivityRoute:ActivityCrossFeatureRoute() {
    override fun targetClassPath(): String {
        return "com.example.f_project.ProjectActivityView"
    }
}