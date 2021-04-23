package uz.texnopos.namaz.ui.namazBuziladi

import uz.texnopos.namaz.data.dao.ArticlesDao

class NamazBuziladiPresenter(private val dao: ArticlesDao, private val view: NamazBuziladiView) {
    fun getNamazBuziladiArticle(id: Int) {
        view.setNamazBuziladiArticle(dao.getArticleById(id))
    }
}