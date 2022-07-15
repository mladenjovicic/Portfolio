package com.mladenjovicic.portfolio.Data.Model.API

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CollectionAPIModel(

@SerializedName("collection") var collection: List<Collection> = emptyList(),

)

data class Collection(@SerializedName("id") var Id: String,
                @SerializedName("name") var Name: String,
                @SerializedName("type") var Type: String,
                @SerializedName("url") var Url: String,
                @SerializedName("description") var Description: String):Serializable
