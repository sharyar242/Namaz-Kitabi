package com.example.h.ui.qiriqPariz

import com.example.h.data.dao.ArticlesDao

class QiriqParizPresenter(private val dao: ArticlesDao, private val view: QirqiParizView) {
    fun getAllQiriqPariz(id:Int){
        view.setAllQiriqPariz(dao.getArticleById(id))
    }
}