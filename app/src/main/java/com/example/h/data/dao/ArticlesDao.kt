package com.example.h.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.h.data.model.Article
import java.lang.reflect.Type

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM book")
    fun getAllArticles(): List<Article>

    @Query("SELECT * FROM book WHERE id=:id")
    fun getArticleById(id: Int): Article

}