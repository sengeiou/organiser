package com.example.f_project.fragments.unfinished

import ru.surfstudio.android.core.ui.navigation.fragment.route.FragmentRoute

/**
 * Маршрут [UnfinishedTasksFragmentView].
 */
class UnfinishedTasksRoute : FragmentRoute() {

    override fun getFragmentClass() = UnfinishedTasksFragmentView::class.java
}