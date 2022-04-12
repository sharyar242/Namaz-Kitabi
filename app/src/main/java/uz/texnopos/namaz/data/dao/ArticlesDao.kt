package uz.texnopos.namaz.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.texnopos.namaz.data.model.*

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM book")
    fun getAllArticles(): List<Article>

    @Query("SELECT * FROM book WHERE id=:id")
    fun getArticleById(id: Int): Article

    @Query("SELECT * FROM pariz_namazlar")
    fun getAllParizNamaz(): List<ParizNamaz>

    @Query("SELECT * FROM pariz_namazlar WHERE id=:id")
    fun getParizNamazById(id:Int): ParizNamaz

    @Query("SELECT * FROM namaz WHERE id=:id")
    fun getNamazById(id: Int): Namaz

    @Query("SELECT * FROM sureler")
    fun getAllSureler(): List<Sureler>

    @Query("SELECT * FROM sureler WHERE id=:id")
    fun getSurelerById(id: Int): Sureler

    @Query("SELECT * FROM juma")
    fun getAllJuma(): List<Juma>

    @Query("SELECT * FROM juma WHERE id=:id")
    fun getJumaById(id: Int): Juma

}