package com.example.oopsiecard

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

abstract class DatabaseBuilder: RoomDatabase() {

    companion object{
        @Volatile

        private var INSTANCE: DatabaseBuilder? = null

        fun getDatabase(context: Context): DatabaseBuilder? {
            if(INSTANCE == null){
                synchronized(DatabaseBuilder::class.java){
                    if(INSTANCE == null){
                        INSTANCE = databaseBuilder(
                            context.applicationContext,
                            DatabaseBuilder::class.java,
                            "myDatabase"
                        ).fallbackToDestructiveMigration().build()
                    }
                }
            }
            return INSTANCE
        }
    }
}