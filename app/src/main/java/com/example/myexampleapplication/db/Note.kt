package com.example.myexampleapplication.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Registration")
data class Note (

  @NonNull
  @PrimaryKey()
  public val id:String,

  @NonNull
  @ColumnInfo(name="Name")
  public val name:String,

  @NonNull
  @ColumnInfo(name = "phone")
  public val phone:String,

  @NonNull
  @ColumnInfo(name = "password")
  public val password:String,

  @NonNull
  @ColumnInfo(name="Qualification")
  public val qualification:String


)