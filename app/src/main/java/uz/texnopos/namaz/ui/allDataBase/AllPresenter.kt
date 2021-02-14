package uz.texnopos.namaz.ui.allDataBase

import uz.texnopos.namaz.data.dao.ArticlesDao
import uz.texnopos.namaz.data.firebase.FirebaseHelper

class AllPresenter(private val dao: ArticlesDao, private val view: AllView, private val firebaseHelper: FirebaseHelper) {
    fun getAllArticle(id: Int) {
        view.setAllArticle(dao.getArticleById(id))
//        articleFBHelper.getAllArticle(
//            {
//                view.setAllArticle(dao.getArticleById(id))
//            },
//            {
//                view.showError(it)
//            }
//        )
    }
}