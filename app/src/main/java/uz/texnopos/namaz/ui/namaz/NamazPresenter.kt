package uz.texnopos.namaz.ui.namaz

import uz.texnopos.namaz.data.dao.ArticlesDao
import uz.texnopos.namaz.data.firebase.FirebaseHelper

class NamazPresenter(private val dao: ArticlesDao, private val view: NamazView, private val firebaseHelper: FirebaseHelper) {
    fun getAllNamaz(id: Int) {
        view.setNamaz(dao.getArticleById(id))
        firebaseHelper.getAllArticle(
            {
                view.setNamaz(dao.getArticleById(id))
            },
            {
                view.showError(it)
            }
        )
    }

}