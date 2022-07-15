package com.mladenjovicic.portfolio.Data.Model.API

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TreeAPIModel(
    @SerializedName("id") var Id: String,
    @SerializedName("name") var Name: String,
    @SerializedName("type") var Type: String,
    @SerializedName("collection") var collection: List<TreeCollection> = emptyList(),
)

data class TreeCollection(
    @SerializedName("id") var Id: String,
    @SerializedName("name") var Name: String,
    @SerializedName("type") var Type: String,
    @SerializedName("collection") var TreeCollection: List<TreeCollectionColection> = emptyList()
):Serializable

data class TreeCollectionColection(
    @SerializedName("id") var Id: String,
    @SerializedName("name") var Name: String,
    @SerializedName("type") var Type: String
    //@SerializedName("collection") var collection: List<kotlin.collections.Collection> = emptyList(),
    ):Serializable