package uz.texnopos.namaz.ui.jumaNamaz

import uz.texnopos.namaz.data.dao.ArticlesDao

class JumaNamazPresenter(private val dao: ArticlesDao, private val view: JumaNamazView) {
    fun getJumaNamazArticle(id: Int) {
        view.setJumaNamazArticle(dao.getArticleById(id))
    }
}