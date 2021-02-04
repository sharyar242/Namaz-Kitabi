package uz.texnopos.namaz.ui.namaz

import uz.texnopos.namaz.data.dao.ArticlesDao

class NamazPresenter(private val dao: ArticlesDao, private val view: NamazView) {
    fun getAllNamaz(id: Int) {
        view.setNamaz(dao.getArticleById(id))
    }

}