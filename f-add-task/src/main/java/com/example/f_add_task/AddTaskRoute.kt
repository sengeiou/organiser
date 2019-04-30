package com.example.f_add_task

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityRoute

/**
 * Маршрут [AddTaskActivityView].
 */
class AddTaskRoute : ActivityRoute() {
    override fun prepareIntent(context: Context) = Intent(context, AddTaskActivityView::class.java).apply {
    }
}