package com.example.h.ui.namazBuziladi

import com.example.h.data.dao.ArticlesDao

class NamazBuziladiPresenter (private val dao: ArticlesDao, private val view: NamazBuziladiView){
    fun getAllNamazBuziladi(id: Int){
        view.setAllNamazBuziladi(dao.getArticleById(id))
    }
}