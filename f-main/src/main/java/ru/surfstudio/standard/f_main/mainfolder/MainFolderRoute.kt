package ru.surfstudio.standard.f_main.projects

import ru.surfstudio.android.core.ui.navigation.fragment.route.FragmentRoute


/**
 * Маршрут [MainListFragmentView].
 */
class MainFolderRoute : FragmentRoute() {

    override fun getFragmentClass() = MainFolderFragmentView::class.java
}