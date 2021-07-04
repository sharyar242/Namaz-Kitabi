package uz.texnopos.namaz.ui.dualar

import uz.texnopos.namaz.data.dao.ArticlesDao

class DualarPresenter(private val dao: ArticlesDao, private val view: DualarView) {
    fun getDualarArticle(id: Int) {
        view.setDualarArticle(dao.getArticleById(id)!!)
    }
}