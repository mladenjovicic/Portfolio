package com.mladenjovicic.portfolio.Data.LocalData

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mladenjovicic.portfolio.Data.Model.DB.*


@Database(
    entities = [CollectionDBModel::class, TreeDBModel::class,CollectionTreeDBModel::class, SubCollectionTreeDBModel::class],
    version = 2,
    exportSchema = false
)
abstract class PortfolioDatabase: RoomDatabase() {
    abstract fun collectionDAO(): DAOAcessCollection
    abstract fun treeDAO(): DAOAcessTree
}