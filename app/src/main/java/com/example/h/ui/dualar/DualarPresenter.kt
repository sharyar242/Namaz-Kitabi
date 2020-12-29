package com.example.h.ui.dualar

import com.example.h.data.dao.ArticlesDao


class DualarPresenter(private val dao : ArticlesDao, private val view : DualarView) {
    fun getAllDualar(id: Int){
        view.setAllDualar(dao.getArticleById(id))

    }

}