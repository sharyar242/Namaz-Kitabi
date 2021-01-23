package com.example.h.ui.allDataBase

import com.example.h.data.dao.ArticlesDao

class AllPresenter(private val dao: ArticlesDao, private val view: AllView) {
    fun getAllArticle(id: Int) {
        view.setAllArticle(dao.getArticleById(id))
    }
}