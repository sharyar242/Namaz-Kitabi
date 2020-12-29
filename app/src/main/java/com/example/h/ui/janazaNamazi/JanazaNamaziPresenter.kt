package com.example.h.ui.janazaNamazi

import com.example.h.data.dao.ArticlesDao

class JanazaNamaziPresenter (private val dao: ArticlesDao, private val view: JanazaNamaziView){
    fun getAllJanazaNamazi(id: Int){
        view.setAllJanazaNamazi(dao.getArticleById(id))
    }
}