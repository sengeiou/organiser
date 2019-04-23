package ru.surfstudio.standard.ui.navigation

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureRoute
import ru.surfstudio.standard.ui.navigation.FeatureRoute.ActivityCrossWithParamsRoute
import ru.surfstudio.standard.ui.navigation.FeatureRoute.FragmentCrossFeatureRoute

class ProjectActivityRoute(val projectid:Long):ActivityCrossWithParamsRoute() {
    override fun targetClassPath(): String {
        return "com.example.f_project.ProjectActivityView"
    }

    override fun prepareIntent(context: Context): Intent? {
        return super.prepareIntent(context)?.putExtra("PROJECT_ID",projectid)
    }
}