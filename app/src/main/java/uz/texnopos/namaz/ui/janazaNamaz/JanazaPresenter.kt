package uz.texnopos.namaz.ui.janazaNamaz

import uz.texnopos.namaz.data.dao.ArticlesDao
import uz.texnopos.namaz.ui.shahada.ShahadaView

class JanazaPresenter(private val dao: ArticlesDao, private val view: JanazaView) {
    fun getJanazaArticle(id: Int) {
        view.setJanazaArticle(dao.getArticleById(id))
    }
}