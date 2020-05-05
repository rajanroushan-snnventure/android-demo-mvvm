package com.example.myexampleapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class],version = 3,exportSchema = false)
abstract class NoteRoomDatabase:RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        var INSTANCE: NoteRoomDatabase? = null

        fun getAppDataBase(context: Context): NoteRoomDatabase {
                    val tempInstance = INSTANCE
                    if (tempInstance != null) {
                        return tempInstance
                    }
                    synchronized(this) {
                        val instance = Room.databaseBuilder(
                            context.applicationContext,
                            NoteRoomDatabase::class.java,
                            "note_database"
                        ).build()
                        INSTANCE = instance
                        return instance
                    }

                }
            }
        }






