package com.example.f_add_folder

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.f_add_folder.di.AddFolderScreenConfigurator
import kotlinx.android.synthetic.main.addfolder_toolbar.*
import ru.surfstudio.android.core.mvp.activity.BaseRenderableActivityView
import ru.surfstudio.standard.domain.folder.Folder
import javax.inject.Inject


/**
 * Вью TODO
 */
class AddFolderActivityView : BaseRenderableActivityView<AddFolderScreenModel>() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_ok) {
            presenter.addFolder(Folder(0,1,"Моя папка"))
        }
        return true
    }

    @Inject
    lateinit var presenter: AddFolderPresenter

    override fun getScreenName() = "AddFolderActivityView"

    override fun getPresenters() = arrayOf(presenter)

    override fun createConfigurator() = AddFolderScreenConfigurator(intent)

    override fun getContentView(): Int = R.layout.activity_add_folder

    override fun onCreate(
            savedInstanceState: Bundle?,
            persistentState: PersistableBundle?,
            viewRecreated: Boolean
    ) {
        initToolbar()

        initListeners()
        val user = intent.extras.getInt("FOLDER_ID")
        Log.d(screenName, user.toString())
    }

    private fun initToolbar() {
        setSupportActionBar(addFolder_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Создание папки"
    }

    override fun renderInternal(screenModel: AddFolderScreenModel) {

    }

    private fun initListeners() {
        backButtonListener()
    }

    private fun backButtonListener() {
        addFolder_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}