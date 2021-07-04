package uz.texnopos.namaz.ui.qiriqParz

import uz.texnopos.namaz.data.dao.ArticlesDao

class QiriqParzPresenter(private val dao: ArticlesDao, private val view: QiriqParzView) {
    fun getQiriqParzArticle(id: Int) {
        view.setQiriqParzArticle(dao.getArticleById(id)!!)
    }
}