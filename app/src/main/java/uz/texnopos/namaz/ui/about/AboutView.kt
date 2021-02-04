package uz.texnopos.namaz.ui.about

import uz.texnopos.namaz.data.model.Article

interface AboutView {
    fun setAllArticle(article: Article)
}