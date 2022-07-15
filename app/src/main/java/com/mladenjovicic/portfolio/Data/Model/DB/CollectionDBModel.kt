package com.mladenjovicic.portfolio.Data.Model.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "collection", indices = arrayOf(Index(value = arrayOf("serverId"), unique = true)))
data class CollectionDBModel(
    @ColumnInfo(name="serverId")
    var serverId:String?,
    @ColumnInfo(name ="name")
    var name:String?,
    @ColumnInfo(name ="type")
    var type:String?,
    @ColumnInfo(name ="url")
    var url:String?,
    @ColumnInfo(name ="description")
    var description:String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id:Int?=null
}
