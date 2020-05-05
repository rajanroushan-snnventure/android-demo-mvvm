package com.example.myexampleapplication.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myexampleapplication.db.NoteRoomDatabase
import com.example.myexampleapplication.db.RegistrationRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val TAG:String="LoginViewModel"
    private val repository: RegistrationRepo;

    init {
        val regDao = NoteRoomDatabase.getAppDataBase(application).noteDao()
        repository = RegistrationRepo(regDao)
    }

    fun findUserPhone(phone:String)= viewModelScope.launch(Dispatchers.IO){

        repository.findUserPhone(phone)

    }
}