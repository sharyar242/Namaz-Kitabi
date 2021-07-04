package uz.texnopos.namaz.ui.namaz

import uz.texnopos.namaz.data.model.Namaz

interface NamazView {
    fun setNamaz(article: Namaz)
}