package ru.surfstudio.standard.f_main.main

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fab_layout.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import ru.surfstudio.android.core.mvp.presenter.CorePresenter
import ru.surfstudio.android.core.ui.FragmentContainer
import ru.surfstudio.android.template.f_main.R
import ru.surfstudio.standard.f_main.main.di.MainScreenConfigurator
import javax.inject.Inject


/**
 * Вью главного экрана
 */
class MainActivityView : BaseRenderableActivityView<MainScreenModel>(), FragmentContainer {

    @Inject
    lateinit var presenter: MainPresenter

    private var fabIsOpen = false
    lateinit var fabAnimShow: Animation
    lateinit var tvAnimShow: Animation
    lateinit var fabFoldeAnimHide: Animation
    lateinit var fabProjectAnimHide: Animation

    override fun getPresenters(): Array<CorePresenter<*>> = arrayOf(presenter)

    override fun createConfigurator() = MainScreenConfigurator(intent)

    @LayoutRes
    override fun getContentView(): Int = R.layout.activity_main

    override fun getContentContainerViewId() = R.id.containermain

    override fun getScreenName(): String = "MainActivityView"

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        initAnims()
        initListeners()
        Log.d("PROJECTS","ADD PROJECT")
    }

    private fun initAnims() {
        fabAnimShow = AnimationUtils.loadAnimation(this, R.anim.projects_show_menu_fab)
        tvAnimShow = AnimationUtils.loadAnimation(this, R.anim.projects_tv_fab_show)
        fabFoldeAnimHide = AnimationUtils.loadAnimation(this, R.anim.projects_hide_menu_fabfolder)
        fabProjectAnimHide = AnimationUtils.loadAnimation(this, R.anim.projects_hide_menu_fabproject)

    }

    override fun renderInternal(sm: MainScreenModel) {
    }

    private fun initListeners() {
        initFabListener()
    }

    private fun initFabListener() {
        projects_add_fab.setOnClickListener {
            if (!fabIsOpen)
                showFabMenu()
            else hideFabMenu()

        }
    }

    private fun hideFabMenu() {
        hideAddProjectFab()
        hideAddProjectTv()
        hideAddFolderFab()
        hideAddFolderTv()
        changeMainFabToOpen()
        fabIsOpen = false

    }

    private fun changeMainFabToOpen() {
        val resID = resources.getIdentifier("baseline_add_black_24", "drawable", applicationContext.packageName)
        projects_add_fab.setImageResource(resID)
    }

    private fun hideAddFolderTv() {
        projects_add_folder_tv.startAnimation(fabFoldeAnimHide)
    }

    private fun hideAddFolderFab() {
        projects_addFolder_fab.startAnimation(fabFoldeAnimHide)
    }

    private fun hideAddProjectTv() {
        projects_add_project_tv.startAnimation(fabProjectAnimHide)
    }

    private fun hideAddProjectFab() {
        projects_addProject_fab.startAnimation(fabProjectAnimHide)
    }

    private fun showFabMenu() {
        showAddDolderFab()
        showAddFolderTv()
        showAddProjectFab()
        showAddProjectTv()
        changeMainFabToClose()
        fabIsOpen = true
    }

    private fun changeMainFabToClose() {
        val resID = resources.getIdentifier("baseline_close_black_24", "drawable", applicationContext.packageName)
        projects_add_fab.setImageResource(resID)
    }

    private fun showAddFolderTv() {
        projects_add_folder_tv.startAnimation(tvAnimShow)
    }

    private fun showAddDolderFab() {
        projects_addFolder_fab.startAnimation(fabAnimShow)
        projects_addFolder_fab.isClickable = true
    }

    private fun showAddProjectFab() {
        projects_addProject_fab.startAnimation(fabAnimShow)
        projects_addProject_fab.isClickable = true
    }

    private fun showAddProjectTv() {
        projects_add_project_tv.startAnimation(tvAnimShow)
    }
}
