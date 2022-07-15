package com.mladenjovicic.portfolio.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mladenjovicic.portfolio.Data.Model.DB.SubCollectionTreeDBModel
import com.mladenjovicic.portfolio.Data.Repository.LoadingRepository
import com.mladenjovicic.portfolio.Data.Repository.VaseRepository

class MainViewModel(private val vaseRepository: VaseRepository) : ViewModel() {
    var subCollectionLiveData: LiveData<List<SubCollectionTreeDBModel>>?= null


    fun getSubCollectionLocalData(): LiveData<List<SubCollectionTreeDBModel>>?{
        subCollectionLiveData = vaseRepository.getSubCollectionLocalData()
        return subCollectionLiveData
    }

}