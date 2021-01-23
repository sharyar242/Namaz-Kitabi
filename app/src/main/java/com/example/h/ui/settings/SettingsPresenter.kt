package com.example.h.ui.settings

import com.example.h.data.dao.ArticlesDao

class SettingsPresenter(private val dao: ArticlesDao, private val view: SettingsView) {
    fun getAllSettings(id:Int){
        view.setAllSettings(dao.getArticleById(id))
    }
}