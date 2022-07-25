package com.mladenjovicic.portfolio.Data.Repository

import androidx.lifecycle.LiveData
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.SubCollectionTreeDBModel
import com.mladenjovicic.portfolio.Data.Repository.Local.LocalRepository
import com.mladenjovicic.portfolio.Data.ServerData.RetrofitService

class VaseRepository(
    private val retrofitService: RetrofitService,
    private val localRepository: LocalRepository
) {
    fun getSubCollectionLocalData():LiveData<List<SubCollectionTreeDBModel>>?{

        return localRepository.getSubCollectionLocalData()

    }

    fun getVasaDetailes(vaseId: String):LiveData<CollectionDBModel>?{
        return localRepository.getVasaDetailes(vaseId)
    }

    fun updateVasaID(name:String,descritpion:String, serverId:String) {
        localRepository.updateVasaID(name, descritpion, serverId)
    }

    }