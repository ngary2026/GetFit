package com.example.bitfit

import android.app.Application
import androidx.room.Room

class BitFitApplication : Application() {
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "bitfit-db"
        )
        .fallbackToDestructiveMigration()
        .build()
    }
}