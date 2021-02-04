package uz.texnopos.namaz.ui.namaz

import uz.texnopos.namaz.data.model.Article

interface NamazView {
    fun setNamaz(article: Article)
}