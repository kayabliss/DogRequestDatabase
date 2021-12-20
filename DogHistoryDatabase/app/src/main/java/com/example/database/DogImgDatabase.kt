package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Annotate Class with @Database and include list of entities so that room know this is our database
@Database(entities = arrayOf(DogData::class), version = 1, exportSchema = false)// define which entity class it is, and define it as dogPhoto, and the version

// Declare an Abstract Class that extends RoomDatabase
abstract class DogImgDatabase : RoomDatabase() {//DogImgDatabase extends a RoomDatabase

    abstract fun dogDao():DogDao

    // Create an abstract function that returns a reference to the Dao Class inside of the DogImageDatabase class
    // abstract fun dogDao():DogDao// This is pointing at the Dao


    //We need to initialized the data base so that we can use all the methods we have define in our Dao class
    //The companion object allows clients to access the methods for creating or getting the database without instantiating the class. Since the only purpose of this class is to provide a database, there is no reason to ever instantiate it.
    companion object {
        // We defined a singleton of DogImgDatabase  to prevent having multiple instances of the database opened at the same time

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile// volatile annotation means variable will never be cached
        private var INSTANCE: DogImgDatabase? = null

        fun getDatabase(context: Context): DogImgDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DogImgDatabase::class.java, "dogphoto_database"
                ).build()
                    INSTANCE = instance
                //return instance
               instance
            }
        }
    }
}
