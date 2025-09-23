package com.supervital.data.database.entries

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntry (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "user_id")
    val id: Int? = 0,
    @ColumnInfo(name = "user_name")
    val name: String = "",
    @ColumnInfo(name = "age")
    val age: Int = 0
)