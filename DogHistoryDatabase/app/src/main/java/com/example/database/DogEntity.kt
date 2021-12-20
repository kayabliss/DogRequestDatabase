package com.example.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "PreviousDogTable")
data class DogData(
    @PrimaryKey(autoGenerate = true)
    @NonNull

    @ColumnInfo(name = "id")
    val id: Int = 0,

    @Json(name ="message")
    @ColumnInfo(name = "url")
    val imageUrl: String?,

    @Json(name = "status")
    @ColumnInfo(name = "completed")
    var status: String?,

)
