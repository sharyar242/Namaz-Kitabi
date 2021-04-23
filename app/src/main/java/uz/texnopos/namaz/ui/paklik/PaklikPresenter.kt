package uz.texnopos.namaz.ui.paklik

import uz.texnopos.namaz.data.dao.ArticlesDao

class PaklikPresenter(private val dao: ArticlesDao, private val view: PaklikView) {
    fun getPaklikArticle(id: Int) {
        view.setPaklikArticle(dao.getArticleById(id))
    }
}