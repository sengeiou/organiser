package ru.surfstudio.standard.ui.navigation.FeatureRoute

import android.content.Intent
import ru.surfstudio.android.core.ui.navigation.feature.route.feature.ActivityCrossFeatureRoute

abstract class ActivityCrossWithParamsRoute:ActivityCrossFeatureRoute {
    constructor() {
        //empty
    }

    @Suppress("ConvertSecondaryConstructorToPrimary", "UNUSED_PARAMETER")
    constructor(intent: Intent) : this()
}