package com.example.indi31m6.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Frases::class), version = 1, exportSchema = false)
public abstract class FrasesRoomDatabase: RoomDatabase(){
    abstract fun frasesDao(): FrasesDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FrasesRoomDatabase? = null

        fun getDatabase(context: Context): FrasesRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FrasesRoomDatabase::class.java,
                    "frase_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}