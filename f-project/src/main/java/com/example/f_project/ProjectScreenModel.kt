package com.example.f_project

import ru.surfstudio.android.core.mvp.model.ScreenModel

/**
 * Модель [ProjectActivityView].
 */
class ProjectScreenModel(var projectName:String = "",
                         var projectDescription:String = "",
                         var projectProgress:Int = 0) : ScreenModel() {
}