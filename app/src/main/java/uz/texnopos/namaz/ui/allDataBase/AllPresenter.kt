package uz.texnopos.namaz.ui.allDataBase

import uz.texnopos.namaz.data.dao.ArticlesDao

class AllPresenter(private val dao: ArticlesDao, private val view: AllView) {
    fun getAllArticle(id: Int) {
        view.setAllArticle(dao.getArticleById(id))
    }
}