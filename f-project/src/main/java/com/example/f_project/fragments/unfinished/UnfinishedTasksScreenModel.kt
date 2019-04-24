package com.example.f_project.fragments.unfinished

import ru.surfstudio.android.core.mvp.model.ScreenModel
import ru.surfstudio.standard.domain.project.Task

/**
 * Модель [UnfinishedTasksFragmentView].
 */
class UnfinishedTasksScreenModel(var tasksList:ArrayList<Task> = arrayListOf()) : ScreenModel() {
    fun hasContent():Boolean = tasksList.isNotEmpty()
}