package com.example.oopsiecard

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [PunchedHoles::class], version = 2, exportSchema = false)
abstract class DatabaseBuilder: RoomDatabase() {

    abstract fun punchedHolesDAO(): PunchedHolesDAO

    companion object{
        @Volatile

        private var INSTANCE: DatabaseBuilder? = null

       @JvmStatic
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