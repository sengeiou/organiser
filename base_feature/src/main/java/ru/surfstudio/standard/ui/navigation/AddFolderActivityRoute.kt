package ru.surfstudio.standard.ui.navigation

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.event.result.SupportOnActivityResultRoute
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.ui.navigation.FeatureRoute.ActivityCrossWithParamsRoute

class AddFolderActivityRoute : ActivityCrossWithParamsRoute, SupportOnActivityResultRoute<Long> {
    private var folderId:Long? = null

    constructor(folderId: Long?){
        this.folderId = folderId
    }
    constructor(){
        //empty
    }
    override fun parseResultIntent(intent: Intent?): Long? {
        return intent?.getLongExtra("ADDED_FOLDER_ID",1)
    }

    override fun prepareResultIntent(folderId: Long?): Intent? {
        val intent = Intent()
        return intent.putExtra("ADDED_FOLDER_ID", folderId)
    }

    override fun getRequestCode(): Int {
        return 1
    }


    override fun targetClassPath(): String {
        return "com.example.f_add_folder.AddFolderActivityView"
    }

    override fun prepareIntent(context: Context): Intent? {
        return super.prepareIntent(context)?.putExtra("FOLDER_ID", folderId)
    }
}