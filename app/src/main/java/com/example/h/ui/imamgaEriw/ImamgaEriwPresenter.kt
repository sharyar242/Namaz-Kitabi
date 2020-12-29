package com.example.h.ui.imamgaEriw

import com.example.h.data.dao.ArticlesDao

class ImamgaEriwPresenter(private val dao: ArticlesDao, private val view: ImamgaEriwView) {
    fun getAllImamgaEriw(id: Int){
        view.setAllImamgaEriw(dao.getArticleById(id))
    }

}