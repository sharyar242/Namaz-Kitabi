package uz.texnopos.namaz.ui.shahada

import uz.texnopos.namaz.data.dao.ArticlesDao

class ShahadaPresenter(private val dao: ArticlesDao, private val view: ShahadaView) {
    fun getShahadaArticle(id: Int) {
        view.setShahadaArticle(dao.getArticleById(id))
    }
}