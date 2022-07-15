package com.mladenjovicic.portfolio.Data.ServerData

import com.mladenjovicic.portfolio.Data.Model.API.*
import retrofit2.Call
import retrofit2.http.*
interface RetrofitInterface {

    @GET("collection.json")
    fun getCollection():Call<CollectionAPIModel>

    @GET("tree.json")
    fun getTree():Call<TreeAPIModel>
}