package uz.texnopos.namaz.ui.settings

import uz.texnopos.namaz.data.model.Article

interface SettingsView {
    fun setAllSettings(article: Article)
    fun showError(msg: String?)
}