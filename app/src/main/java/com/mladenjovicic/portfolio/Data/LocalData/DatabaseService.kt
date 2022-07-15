package com.mladenjovicic.portfolio.Data.LocalData

import android.content.Context
import androidx.room.Room

class DatabaseService private constructor(private val applicationContext: Context) {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            PortfolioDatabase::class.java,
            "portfolio_database"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    val collectionDAO: DAOAcessCollection
        get() = database.collectionDAO()

    val treeDAO: DAOAcessTree
        get() = database.treeDAO()



    companion object {
        @Volatile
        private var instance: DatabaseService? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: DatabaseService(context).also { instance = it }
        }
}
}