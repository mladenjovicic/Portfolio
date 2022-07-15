package com.mladenjovicic.portfolio.Data.Model.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "tree", indices = arrayOf(Index(value = arrayOf("serverId"), unique = true)))
data class TreeDBModel(
    @ColumnInfo(name="serverId")
    var serverId:String?,
    @ColumnInfo(name ="name")
    var name:String?,
    @ColumnInfo(name ="type")
    var type:String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id:Int?=null
}