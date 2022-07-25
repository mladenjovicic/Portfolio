package com.mladenjovicic.portfolio.ui.vase.vaseEdit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionDBModel
import com.mladenjovicic.portfolio.Data.Repository.VaseRepository

class VaseEditViewModel (private val vaseRepository: VaseRepository) : ViewModel() {
    var vaseDetalisLiveData : LiveData<CollectionDBModel>?=null
    fun getVasaDetailes(vaseId: String): LiveData<CollectionDBModel>?{

        vaseDetalisLiveData = vaseRepository.getVasaDetailes(vaseId)
        return vaseDetalisLiveData;
    }

    fun updateVasaID(name:String,descritpion:String, serverId:String) {
        vaseRepository.updateVasaID(name, descritpion, serverId)
        }
    }