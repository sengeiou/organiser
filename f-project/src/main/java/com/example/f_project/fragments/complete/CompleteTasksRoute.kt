package com.example.f_project.fragments.complete

import ru.surfstudio.android.core.ui.navigation.fragment.route.FragmentRoute

/**
 * Маршрут [CompleteTasksFragmentView].
 */
class CompleteTasksRoute : FragmentRoute() {
    override fun getFragmentClass() = CompleteTasksFragmentView::class.java
}