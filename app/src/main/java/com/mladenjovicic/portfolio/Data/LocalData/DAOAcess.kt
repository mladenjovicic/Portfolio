package com.mladenjovicic.portfolio.Data.LocalData


import com.mladenjovicic.portfolio.Data.Model.DB.*
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAOAcessCollection {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collectionDBModel:CollectionDBModel)

    @Query("select * from collection order by serverId asc")
    fun getListCollection():LiveData<List<CollectionDBModel>>?

    @Query("select * from collection where serverId= :vaseId")
    fun getVasaDetailes(vaseId: String):LiveData<CollectionDBModel>

    @Query("update  collection set name = :name and description=:descritpion  where serverId = :serverId")
    fun updateVasaID(name:String,descritpion:String, serverId:String )
}
@Dao
interface  DAOAcessTree{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTree(treeDBModel: TreeDBModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollectionTree(collectionTreeDBModel: CollectionTreeDBModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubCollectionTree(subCOllectionTreeDBModel: SubCollectionTreeDBModel)

    @Query("select * from tree order by serverId asc")
    fun getListTree():LiveData<List<TreeDBModel>>?

    @Query("select * from  subCollectionTree order by serverId asc")
    fun getListSubColllection():LiveData<List<SubCollectionTreeDBModel>>

    //@Query("select  subCollectionTree.serverId,  collection.name, collection.description, collection.url from subCollectionTree left join collection on collection.serverId= subCollectionTree.serverId  ")
    //fun getVaseDetalis(vaseId:String)


}