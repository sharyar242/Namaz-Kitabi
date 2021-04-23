package uz.texnopos.namaz.ui.sureler

import uz.texnopos.namaz.data.dao.ArticlesDao

class SurelerPresenter (private val dao: ArticlesDao, private val view: SurelerView){
    fun getSurelerArticle(id: Int) {
        view.setSurelerArticle(dao.getArticleById(id))
    }
}