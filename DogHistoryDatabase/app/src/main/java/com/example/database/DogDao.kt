package com.example.database

import androidx.room.*
import androidx.room.Insert
import kotlinx.coroutines.flow.Flow


@Dao// This will let room know that this is our data access class
interface DogDao {// Interface allows us to access the methods we will create

    //query to insert a new image into the database that accepts a dogData as an argument

    @Insert(onConflict = OnConflictStrategy.IGNORE)// inserts information
    // if there is a row with similar things, add a parameter onConflict, we want to replace with a new row
       fun insertImage(dogEntity: DogEntity)

    @Update
     fun update(dogEntity: DogEntity)

    @Query("SELECT * FROM previousdogtable")
    fun allPets(): Flow<List<DogEntity>>

    @Query("SELECT * FROM previousdogtable")
    fun getAllDogs(): Flow<List<DogEntity>>

    // create a query that will receive the last image in the database
    @Query("SELECT * FROM previousdogtable ORDER BY id DESC LIMIT 1")
     fun getNewImage() : DogEntity?


}