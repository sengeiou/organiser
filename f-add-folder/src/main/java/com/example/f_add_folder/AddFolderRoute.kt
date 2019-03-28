package com.example.f_add_folder

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityRoute
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityWithParamsRoute

/**
 * Маршрут [AddFolderActivityView].
 */
class AddFolderRoute : ActivityWithParamsRoute() {

    override fun prepareIntent(context: Context) = Intent(context, AddFolderActivityView::class.java).apply {
    }
}