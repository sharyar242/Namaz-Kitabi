package com.example.h.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.h.data.model.Articles

@Dao

interface ArticlesDao {

    @Query("SELECT * FROM book")
    fun getAllArticles(): List<Articles>

}