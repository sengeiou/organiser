package com.example.f_project.fragments.complete

import ru.surfstudio.android.core.mvp.model.ScreenModel
import ru.surfstudio.standard.domain.project.Task

/**
 * Модель [CompleteTasksFragmentView].
 */
class CompleteTasksScreenModel(var tasksList:ArrayList<Task> = arrayListOf()) : ScreenModel() {
    fun hasContent():Boolean = tasksList.isNotEmpty()
}