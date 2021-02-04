package uz.texnopos.namaz.ui.settings

import uz.texnopos.namaz.data.dao.ArticlesDao

class SettingsPresenter(private val dao: ArticlesDao, private val view: SettingsView) {
    fun getAllSettings(id:Int){
        view.setAllSettings(dao.getArticleById(id))
    }
}