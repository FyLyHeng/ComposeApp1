package com.fylyheng.composeapp1.room_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fylyheng.composeapp1.room_db.note.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase?= null

        fun getInstance(context: Context) : AppDatabase? {

            synchronized(this) {

                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        klass = AppDatabase::class.java,
                        name = "note_app_db"
                    ).build()
                }
                INSTANCE = instance
            }

            return INSTANCE!!
        }
    }


}