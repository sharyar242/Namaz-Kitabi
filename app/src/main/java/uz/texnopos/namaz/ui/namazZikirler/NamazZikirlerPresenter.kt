package uz.texnopos.namaz.ui.namazZikirler

import uz.texnopos.namaz.data.dao.ArticlesDao

class NamazZikirlerPresenter(private val dao: ArticlesDao, private val view: NamazZikirlerView) {
    fun getNamazZikirlerArticle(id: Int) {
        view.setNamazZikirlerArticle(dao.getArticleById(id))
    }
}