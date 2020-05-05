package com.example.myexampleapplication.ui.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myexampleapplication.db.Note
import com.example.myexampleapplication.db.NoteRoomDatabase
import com.example.myexampleapplication.db.RegistrationRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


 class RegistrationViewModel(application: Application,phone:String): AndroidViewModel(application) {

    private val TAG:String="RegistrationViewModel"

    private val repository: RegistrationRepo
    val phoneAvl: LiveData<String>
    init {
        val regDao = NoteRoomDatabase.getAppDataBase(application).noteDao()
        repository = RegistrationRepo(regDao,phone)
        phoneAvl = repository.phoneAvl

    }
    fun insert(regUser: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(regUser)
    }




}