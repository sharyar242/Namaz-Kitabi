package uz.texnopos.namaz.ui.imamgaEriw

import uz.texnopos.namaz.data.dao.ArticlesDao

class ImamgaEriwPresenter(private val dao: ArticlesDao, private val view: ImamgaEriwView) {
    fun getImamgaEriwArticle(id: Int) {
        view.setImamgaEriwArticle(dao.getArticleById(id))
    }
}