package ru.surfstudio.standard.ui.navigation.FeatureRoute

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.surfstudio.android.core.ui.navigation.FragmentRouteInterface

abstract class FragmentCrossFeatureWithParamsRoute : FragmentCrossFeatureRoute, FragmentRouteInterface {

    constructor() {
        //empty
    }

    @Suppress("ConvertSecondaryConstructorToPrimary", "UNUSED_PARAMETER")
    constructor(bundle: Bundle) : this()

    override fun createFragment(): Fragment {
        return super.createFragment().apply {
            arguments = prepareBundle()
        }
    }
}