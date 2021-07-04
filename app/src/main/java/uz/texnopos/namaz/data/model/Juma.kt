package uz.texnopos.namaz.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "juma")
class Juma (
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "theme")
    val theme: String,

    @ColumnInfo(name = "article")
    val article: String

):IgnoreType(4)