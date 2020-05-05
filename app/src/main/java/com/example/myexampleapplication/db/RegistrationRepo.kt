package com.example.myexampleapplication.db

import androidx.lifecycle.LiveData
import com.example.myexampleapplication.ui.registration.RegistrationModel

class RegistrationRepo(val regDao: NoteDao, var phone:String?) {


    suspend fun insert(regUser: Note) {
        regDao.insert(regUser)
    }

    val phoneAvl: LiveData<String> = regDao.findUserPhone(phone=phone!!)


}