package com.example.h.ui.shahada

import com.example.h.data.dao.ArticlesDao

class ShahadaPresenter (private val dao: ArticlesDao, private val view: ShahadaView){
    fun getAllShahada(id:Int){
        view.setAllShahada(dao.getArticleById(id))
    }
}