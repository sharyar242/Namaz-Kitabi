package com.example.h.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.h.data.dao.ArticlesDao
import com.example.h.data.model.Articles

@Database(entities = [Articles::class], version = 1)

abstract class NamazDatabase: RoomDatabase() {

    companion object {
        private lateinit var INSTANCE : NamazDatabase

        fun getInstance(context: Context): NamazDatabase=
            Room.databaseBuilder(context,NamazDatabase::class.java,"Namaz-kitabi").createFromAsset("Namaz-kitabi").build()
    }


    abstract fun articleDao(): ArticlesDao

}