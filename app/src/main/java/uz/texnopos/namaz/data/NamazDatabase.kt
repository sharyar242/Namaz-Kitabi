package uz.texnopos.namaz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import uz.texnopos.namaz.data.dao.ArticlesDao
import uz.texnopos.namaz.data.model.Article
import uz.texnopos.namaz.data.model.Juma
import uz.texnopos.namaz.data.model.Namaz
import uz.texnopos.namaz.data.model.Sureler


@Database(entities = [Article::class, Namaz::class, Sureler::class,Juma::class], version = 1)

abstract class NamazDatabase: RoomDatabase() {

    companion object {
        private lateinit var INSTANCE : NamazDatabase

        fun getInstance(context: Context): NamazDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context,
                    NamazDatabase::class.java,"Namaz-kitabi")
                    .createFromAsset("Namaz-kitabi.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun articleDao(): ArticlesDao
}