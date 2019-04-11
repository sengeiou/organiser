package com.example.f_add_folder

import ru.surfstudio.android.core.mvp.model.ScreenModel

/**
 * Модель [AddFolderActivityView].
 */
class AddFolderScreenModel(var validate: Boolean = false) : ScreenModel() {
    fun isValid():Boolean = validate
}