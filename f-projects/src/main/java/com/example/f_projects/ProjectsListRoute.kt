package ru.surfstudio.standard.f_main.projects

import android.content.Context
import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.fragment.route.FragmentRoute


/**
 * Маршрут [ProjectsListFragmentView].
 */
class ProjectsListRoute : FragmentRoute() {

    override fun getFragmentClass() = ProjectsListFragmentView::class.java
}