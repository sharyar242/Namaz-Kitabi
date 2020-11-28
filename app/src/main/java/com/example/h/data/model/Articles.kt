package com.example.h.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book")

class Articles (
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "type")
    val type: Int,

    @ColumnInfo(name = "theme")
    val theme: String,

    @ColumnInfo(name = "article")
    val article: String

    )