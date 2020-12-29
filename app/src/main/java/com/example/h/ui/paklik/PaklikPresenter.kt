package com.example.h.ui.paklik

import com.example.h.data.dao.ArticlesDao

class PaklikPresenter(private val dao: ArticlesDao, private val view: PaklikView) {
    fun getAllPaklik(id: Int) {
        view.setAllPaklik(dao.getArticleById(id))
    }
}