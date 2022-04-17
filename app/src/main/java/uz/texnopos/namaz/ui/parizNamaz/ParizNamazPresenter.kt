package uz.texnopos.namaz.ui.parizNamaz

import uz.texnopos.namaz.data.dao.ArticlesDao

class ParizNamazPresenter(private val dao: ArticlesDao, private val view: ParizNamazView) {
    fun getAllParizNamaz(id: Int) {
        view.setParizNamaz(dao.getParizNamazById(id))
    }
}