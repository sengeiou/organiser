package ru.surfstudio.standard.ui.navigation

import ru.surfstudio.standard.ui.navigation.FeatureRoute.FragmentCrossFeatureRoute

class OtherFolderFragmentRoute:FragmentCrossFeatureRoute() {
    override fun targetClassPath(): String {
        return "com.example.cf_other_folder.OtherFolderFragmentView"
    }
}