package ru.surfstudio.standard.ui.navigation

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.activity.route.ActivityWithParamsRoute
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureWithParamsRoute
import ru.surfstudio.standard.ui.navigation.FeatureRoute.ActivityCrossWithParamsRoute

class AddFolderActivityRoute(private val folderId:Int):ActivityCrossWithParamsRoute() {
    override fun targetClassPath(): String {
        return "com.example.f_add_folder.AddFolderActivityView"
    }

    override fun prepareIntent(context: Context): Intent? {
        return super.prepareIntent(context)?.putExtra("FOLDER_ID",folderId)
    }
}