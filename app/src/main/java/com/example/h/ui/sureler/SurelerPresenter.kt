package com.example.h.ui.sureler

import com.example.h.data.dao.ArticlesDao

class SurelerPresenter (private val dao: ArticlesDao, private val view: SurelerView) {
    fun getAllSureler(id:Int){
        view.setAllSureler(dao.getArticleById(id))
    }
}