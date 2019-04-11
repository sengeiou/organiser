package com.example.f_add_project

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityRoute

/**
 * Маршрут [AddProjectActivityView].
 */
class AddProjectRoute : ActivityRoute() {

    override fun prepareIntent(context: Context) = Intent(context, AddProjectActivityView::class.java).apply {
    }
}