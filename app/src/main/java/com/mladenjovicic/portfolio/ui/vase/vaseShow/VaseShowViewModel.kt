package com.mladenjovicic.portfolio.ui.vase.vaseShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionDBModel
import com.mladenjovicic.portfolio.Data.Repository.VaseRepository

class VaseShowViewModel (private val vaseRepository: VaseRepository) : ViewModel() {

    var vaseDetalisLiveData :LiveData<CollectionDBModel>?=null
    fun getVasaDetailes(vaseId: String): LiveData<CollectionDBModel>?{

        vaseDetalisLiveData = vaseRepository.getVasaDetailes(vaseId)
        return vaseDetalisLiveData;
    }
}