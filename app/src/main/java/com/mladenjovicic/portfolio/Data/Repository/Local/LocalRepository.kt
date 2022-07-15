package com.mladenjovicic.portfolio.Data.Repository.Local

import androidx.lifecycle.LiveData
import com.mladenjovicic.portfolio.Data.LocalData.DatabaseService
import com.mladenjovicic.portfolio.Data.Model.DB.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LocalRepository(private val databaseService: DatabaseService)  {
    var collectionLiveDBModel: LiveData<List<CollectionDBModel>>? = null
    var treeLiveDBModel: LiveData<List<TreeDBModel>>? = null
    var subCollectionLiveDBModel:LiveData<List<SubCollectionTreeDBModel>>?=null


    fun insertLocalDataCollection(
        collectionDBModel: CollectionDBModel){
        CoroutineScope(IO).launch {
            databaseService.collectionDAO.insertCollection(collectionDBModel)
        }
    }

    fun getListCollection(): LiveData<List<CollectionDBModel>>? {
        collectionLiveDBModel = databaseService.collectionDAO.getListCollection()
        return collectionLiveDBModel
    }

    fun getSubCollectionLocalData():LiveData<List<SubCollectionTreeDBModel>>?{
        subCollectionLiveDBModel = databaseService.treeDAO.getListSubColllection()
        return subCollectionLiveDBModel

    }

    fun insertLocalDataTree(
        treeDBModel: TreeDBModel){
        CoroutineScope(IO).launch {
            databaseService.treeDAO.insertTree(treeDBModel)
        }
    }

    fun insertLocalDataCollectionTree(
        collectionTreeDBModel: CollectionTreeDBModel){
        CoroutineScope(IO).launch {
            databaseService.treeDAO.insertCollectionTree(collectionTreeDBModel)
        }
    }

    fun insertLocalDataSubCollectionTree(
        subCollectionTreeDBModel: SubCollectionTreeDBModel){
        CoroutineScope(IO).launch {
            databaseService.treeDAO.insertSubCollectionTree(subCollectionTreeDBModel)
        }
    }

    fun getListTree(): LiveData<List<TreeDBModel>>? {
        treeLiveDBModel = databaseService.treeDAO.getListTree()
        return treeLiveDBModel
    }
}