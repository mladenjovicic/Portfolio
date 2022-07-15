package com.mladenjovicic.portfolio.Data.Model.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "subCollectionTree", indices = arrayOf(Index(value = arrayOf("serverId"), unique = true)))

data class SubCollectionTreeDBModel(
    @ColumnInfo(name="serverId")
    var serverId:String?,
    @ColumnInfo(name ="name")
    var name:String?,
    @ColumnInfo(name ="type")
    var type:String?,
    @ColumnInfo(name ="CollectionTreeServerId")
    var treeServerId:String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id:Int?=null
}