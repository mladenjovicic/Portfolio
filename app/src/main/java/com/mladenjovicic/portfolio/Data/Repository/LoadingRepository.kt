package com.mladenjovicic.portfolio.Data.Repository

import androidx.lifecycle.MutableLiveData
import com.mladenjovicic.portfolio.Data.Model.API.*
import com.mladenjovicic.portfolio.Data.Model.DB.*
import com.mladenjovicic.portfolio.Data.Model.RequestState
import com.mladenjovicic.portfolio.Data.Repository.Local.LocalRepository
import com.mladenjovicic.portfolio.Data.ServerData.RetrofitService

class LoadingRepository(
    private val retrofitService: RetrofitService,
     private val localRepository: LocalRepository
) {


    fun getCollectionJSON(
        livedata: MutableLiveData<CollectionAPIModel>,
        requestState: MutableLiveData<RequestState>
    ) = retrofitService.getCollectionJSON(livedata, requestState)

    fun getTreeJSON(
        livedata: MutableLiveData<TreeAPIModel>,
        requestState: MutableLiveData<RequestState>
    ) = retrofitService.getTreeJSON(livedata, requestState)

    fun insertCollectionLocal(
        collectionDBModel: CollectionDBModel
    ){
        localRepository.insertLocalDataCollection(
            collectionDBModel
        )
    }

    fun insertTreeLocalData(
        treeDBModel: TreeDBModel
    ){
        localRepository.insertLocalDataTree(
            treeDBModel
        )
    }

    fun insertCollectionTreeLocalData(
        collectionTreeDBModel: CollectionTreeDBModel
    ){
        localRepository.insertLocalDataCollectionTree(
            collectionTreeDBModel
        )
    }
    fun insertSubCollectionTreeLocalData(
        subCollectionTreeDBModel: SubCollectionTreeDBModel
    ){
        localRepository.insertLocalDataSubCollectionTree(
            subCollectionTreeDBModel
        )
    }
}