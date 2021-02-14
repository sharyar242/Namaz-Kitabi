package uz.texnopos.namaz.ui.settings

import uz.texnopos.namaz.data.dao.ArticlesDao
import uz.texnopos.namaz.data.firebase.FirebaseHelper

class SettingsPresenter(private val dao: ArticlesDao, private val view: SettingsView, private val firebaseHelper: FirebaseHelper) {
    fun getAllSettings(id:Int){
        view.setAllSettings(dao.getArticleById(id))
        firebaseHelper.getAllArticle(
            {
                view.setAllSettings(dao.getArticleById(id))
            },
            {
                view.showError(it)
            }
        )
    }
}