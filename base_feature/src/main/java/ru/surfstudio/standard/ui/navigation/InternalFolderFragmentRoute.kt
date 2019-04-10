package ru.surfstudio.standard.ui.navigation

import android.os.Bundle
import ru.surfstudio.standard.domain.folder.Folder
import ru.surfstudio.standard.ui.navigation.FeatureRoute.FragmentCrossFeatureRoute
import ru.surfstudio.standard.ui.navigation.FeatureRoute.FragmentCrossFeatureWithParamsRoute



class InternalFolderFragmentRoute(val folder:Folder):FragmentCrossFeatureWithParamsRoute() {
    override fun prepareBundle(): Bundle {
        val arguments = Bundle()
        arguments.putLong("FOLDER_ID", folder.id)
        arguments.putString("FOLDER_NAME", folder.name)
        return arguments
    }

    override fun targetClassPath(): String {
        return "com.example.cf_internal_folder.InternalFolderFragmentView"
    }

}