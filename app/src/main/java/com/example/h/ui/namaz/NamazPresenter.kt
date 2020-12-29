package com.example.h.ui.namaz

import com.example.h.data.dao.ArticlesDao

class NamazPresenter(private val dao: ArticlesDao, private val view: NamazView) {
    fun getAllNamaz(id: Int){
        view.setAllNamaz(dao.getArticleById(id))
    }
}