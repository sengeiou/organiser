package com.example.f_add_folder

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import com.example.f_add_folder.di.AddFolderScreenConfigurator
import kotlinx.android.synthetic.main.activity_add_folder.*
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
        val folderName = addFolder_folderName_ET.text.toString()
        val parentFolderId = getParentFolderId()
        if (item?.itemId == R.id.action_ok) {
            presenter.addFolder(Folder(0, parentFolderId, folderName))
        }
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
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
    }

    fun getParentFolderId(): Long {
        return intent?.extras?.getLong("FOLDER_ID")!!
    }

    private fun initToolbar() {
        setSupportActionBar(addFolder_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Создание папки"
    }

    override fun renderInternal(screenModel: AddFolderScreenModel) {
        if (!screenModel.isValid()){
            addFolder_folderName_ET.error = "Вы ничего не ввели"
        }

    }

    private fun initListeners() {
    }

}