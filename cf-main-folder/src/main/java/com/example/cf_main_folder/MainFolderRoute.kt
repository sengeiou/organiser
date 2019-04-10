package com.example.cf_main_folder

import ru.surfstudio.android.core.ui.navigation.fragment.route.FragmentRoute


/**
 * Маршрут [MainListFragmentView].
 */
class MainFolderRoute : FragmentRoute() {

    override fun getFragmentClass() = MainFolderFragmentView::class.java
}