package uz.texnopos.namaz.ui.about

import uz.texnopos.namaz.data.dao.ArticlesDao

class AboutPresenter(private val dao: ArticlesDao, private val view: AboutView) {
    fun getAllArticle(id: Int) {
        view.setAboutArticle(dao.getArticleById(id)!!)
    }
}