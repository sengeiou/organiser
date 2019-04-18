package com.example.f_project

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityRoute

/**
 * Маршрут [ProjectActivityView].
 */
class ProjectRoute : ActivityRoute() {

    override fun prepareIntent(context: Context) = Intent(context, ProjectActivityView::class.java).apply {
    }
}