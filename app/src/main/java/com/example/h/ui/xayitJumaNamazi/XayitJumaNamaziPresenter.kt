package com.example.h.ui.xayitJumaNamazi

import com.example.h.data.dao.ArticlesDao

class XayitJumaNamaziPresenter(private val dao: ArticlesDao, private val view: XayitJumaNamaziView) {
    fun getAllXayitJumaNamazi(id:Int){
        view.setAllXayitJumaNamazi(dao.getArticleById(id))
    }

}