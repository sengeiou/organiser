package ru.surfstudio.standard.ui.navigation

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureRoute

class AddTaskActivityRoute:ActivityCrossFeatureRoute() {
    override fun targetClassPath(): String {
        return "com.example.f_add_task.AddTaskActivityView"
    }
}