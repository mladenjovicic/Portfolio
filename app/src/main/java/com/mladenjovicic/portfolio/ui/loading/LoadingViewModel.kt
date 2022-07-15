package com.mladenjovicic.portfolio.ui.loading

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mladenjovicic.portfolio.Data.Model.API.CollectionAPIModel
import com.mladenjovicic.portfolio.Data.Model.API.TreeAPIModel
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionTreeDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.SubCollectionTreeDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.TreeDBModel
import com.mladenjovicic.portfolio.Data.Model.RequestState
import com.mladenjovicic.portfolio.Data.Repository.LoadingRepository

class LoadingViewModel(private val loadingRepository: LoadingRepository) : ViewModel() {


    val requestState = MutableLiveData<RequestState>()
    val collectionAPIModelLiveData = MutableLiveData<CollectionAPIModel>()
    val treeAPIModelLiveData = MutableLiveData<TreeAPIModel>()

    fun getCollectionJSON(){
        loadingRepository.getCollectionJSON(collectionAPIModelLiveData, requestState)
    }

    fun getTreeJSON(){
        loadingRepository.getTreeJSON(treeAPIModelLiveData, requestState)
    }

    fun insertCollectionLocalData(
        collectionDBModel: CollectionDBModel
    ){
        loadingRepository.insertCollectionLocal(collectionDBModel)
    }
    fun insertTreeLocalData(
        treeDBModel: TreeDBModel
    ){
        loadingRepository.insertTreeLocalData(treeDBModel)
    }

    fun insertCollectionTreeLocalData(
        collectionTreeDBModel: CollectionTreeDBModel
    ){
        loadingRepository.insertCollectionTreeLocalData(
            collectionTreeDBModel
        )
    }
    fun insertSubCollectionTreeLocalData(
        subCollectionTreeDBModel: SubCollectionTreeDBModel
    ){
        loadingRepository.insertSubCollectionTreeLocalData(
            subCollectionTreeDBModel
        )
    }
}