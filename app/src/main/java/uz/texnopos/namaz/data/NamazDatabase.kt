package uz.texnopos.namaz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.texnopos.namaz.data.dao.ArticlesDao
import uz.texnopos.namaz.data.model.*

@Database(entities = [Article::class, Namaz::class, Sureler::class,Juma::class, ParizNamaz::class], version = 2)

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