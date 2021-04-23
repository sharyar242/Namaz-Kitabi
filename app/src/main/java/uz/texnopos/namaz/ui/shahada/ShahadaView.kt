package uz.texnopos.namaz.ui.shahada

import uz.texnopos.namaz.data.model.Article

interface ShahadaView {
    fun setShahadaArticle(article: Article)
    fun showError(msg: String?)
}