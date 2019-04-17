package com.example.f_add_project

import ru.surfstudio.android.core.mvp.model.ScreenModel

/**
 * Модель [AddProjectActivityView].
 */
class AddProjectScreenModel(var validate: Boolean = false) : ScreenModel() {
    fun isValid():Boolean = validate
}