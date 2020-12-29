package com.example.h.ui.namazZikirler

import com.example.h.data.dao.ArticlesDao

class NamazZikirlerPresenter(private val dao: ArticlesDao, private val view: NamazZikirlerView) {
    fun getAllZikirlerView(id:Int){
        view.setAllNamazZikirler(dao.getArticleById(id))
    }
}