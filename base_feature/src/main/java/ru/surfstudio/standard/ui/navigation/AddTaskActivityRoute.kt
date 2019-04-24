package ru.surfstudio.standard.ui.navigation

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.event.result.SupportOnActivityResultRoute
import ru.surfstudio.standard.ui.navigation.FeatureRoute.ActivityCrossWithParamsRoute

class AddTaskActivityRoute : ActivityCrossWithParamsRoute
        , SupportOnActivityResultRoute<Long> {

   private var parentProjectId:Long?=null
    constructor(){
        //empty
    }
    constructor(parentProjectId: Long){
        this.parentProjectId = parentProjectId
    }

    override fun parseResultIntent(intent: Intent?): Long {
        return intent?.extras?.getLong("ADDED_TASK_ID")!!
    }

    override fun prepareResultIntent(taskId: Long?): Intent {
        val intent = Intent()
        return intent.putExtra("ADDED_TASK_ID", taskId)
    }

    override fun getRequestCode(): Int {
        return 1
    }

    override fun targetClassPath(): String {
        return "com.example.f_add_task.AddTaskActivityView"
    }

    override fun prepareIntent(context: Context): Intent? {
        return super.prepareIntent(context)?.putExtra("PARENT_PROJECT_ID", parentProjectId)
    }
}