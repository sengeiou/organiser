package ru.surfstudio.standard.ui.navigation

import androidx.fragment.app.Fragment
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.CrossFeatureRoute
import ru.surfstudio.android.core.ui.navigation.fragment.route.FragmentRoute
import ru.surfstudio.android.logger.Logger

abstract class FragmentCrossFeatureRoute:CrossFeatureRoute,FragmentRoute() {


    @Suppress("UNCHECKED_CAST")
    override fun getFragmentClass(): Class<out Fragment>? {
        try {
            return Class.forName(targetClassPath()) as? Class<out Fragment> ?: return null
        } catch (e: ClassNotFoundException) {
            Logger.e("Fragment with the following classpath was not found in the current " +
                    "application: ${targetClassPath()}. If this fragment is the part of Dynamic Feature, " +
                    "please check if this Dynamic Feature is downloaded and installed on the device" +
                    "successfully.")
        }
        return null
    }
}