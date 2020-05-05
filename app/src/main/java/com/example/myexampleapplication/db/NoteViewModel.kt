package com.example.myexampleapplication.db

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myexampleapplication.ui.registration.RegistrationModel


class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val TAG: String = "NoteViewModel"
    private val mutableLiveData = MutableLiveData<String>()


    private var noteDatabase: NoteRoomDatabase? = NoteRoomDatabase.getAppDataBase(application)
    val noteDao: NoteDao? = noteDatabase!!.noteDao()


    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "Cleared")
    }

//    fun fetch():LiveData<List<Note>>?{
//        var allNote:LiveData<List<Note>>?
//        allNote = noteDao?.fetch()
//
//        return allNote
//
//    }

//    fun insert(note: Note): Unit {
//        InsertAsyncTask(noteDao).execute(note)
//    }
//
//    companion object {
//        class InsertAsyncTask(mNoteDao:NoteDao) : AsyncTask<Note, Void, Void>() {
//
//            private var noteDao:NoteDao = mNoteDao
//            override fun doInBackground(vararg params: RegistrationModel): Void? {
//                // ...
//                Log.i("TAG" , params[0].toString())
//                noteDao?.insert(params[0])
//                return null
//            }
//
//        }
//    }
}

