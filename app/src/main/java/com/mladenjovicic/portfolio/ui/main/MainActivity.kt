package com.mladenjovicic.portfolio.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ViewModelsProviderUtils
import com.mladenjovicic.portfolio.ui.adapter.VaseAdapter
import com.mladenjovicic.portfolio.ui.loading.LoadingViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewVaseList: VaseAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelsProviderUtils.getMainViewModel(this)
        initRecyclerVTenderActivList()

        viewModel.getSubCollectionLocalData()
        viewModel.subCollectionLiveData?.observe(this){
            recyclerViewVaseList.setVaseList(it)
            recyclerViewVaseList.notifyDataSetChanged()
        }

    }


    private fun initRecyclerVTenderActivList(){
        val recyclerViewVase= findViewById<RecyclerView>(R.id.recyclerViewVase)
        recyclerViewVaseList = VaseAdapter()
        recyclerViewVase?.adapter = recyclerViewVaseList
    }
}