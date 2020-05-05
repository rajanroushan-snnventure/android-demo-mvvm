package com.example.myexampleapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myexampleapplication.ui.registration.RegistrationModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(registrationModel :Note)

    @Query("SELECT phone FROM Registration WHERE phone=:phone")
    fun findUserPhone(phone:String):LiveData<String>

}