package com.example.f_project.fragments.unfinished

import android.os.Bundle
import ru.surfstudio.android.core.mvp.fragment.BaseRenderableFragmentView
import com.example.f_project.R
import javax.inject.Inject
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.f_project.fragments.unfinished.di.UnfinishedTasksScreenConfigurator

/**
 * Вью TODO
 */
class UnfinishedTasksFragmentView : BaseRenderableFragmentView<UnfinishedTasksScreenModel>() {

    @Inject
    lateinit var presenter: UnfinishedTasksPresenter

    override fun getScreenName() = "UnfinishedTasksFragmentView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = UnfinishedTasksScreenConfigurator(arguments
            ?: bundleOf())

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) = inflater.inflate(R.layout.fragment_unfinished_tasks, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?, viewRecreated: Boolean) {
        initListeners()
    }

    override fun renderInternal(screenModel: UnfinishedTasksScreenModel) {

    }

    private fun initListeners() {

    }
}