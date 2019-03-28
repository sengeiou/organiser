package ru.surfstudio.standard.domain.folder

data class Folder (private val id:Int,
                   private val parentFolderId:Int,
                   private val name:String)