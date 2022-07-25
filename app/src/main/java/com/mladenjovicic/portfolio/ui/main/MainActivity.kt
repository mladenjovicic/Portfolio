package com.mladenjovicic.portfolio.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ViewModelsProviderUtils
import com.mladenjovicic.portfolio.ui.adapter.VaseAdapter
import com.mladenjovicic.portfolio.ui.loading.LoadingViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerViewVaseList: VaseAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var  radioButtonAll:RadioButton
    private lateinit var  radioButtonPainting:RadioButton
    private lateinit var  radioButtonPotteries:RadioButton
    private lateinit var  editTextSearchVasa:EditText
    private lateinit var imageButtonSearch:ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelsProviderUtils.getMainViewModel(this)
        radioButtonAll=findViewById(R.id.radioButtonAll)
        radioButtonPainting = findViewById(R.id.radioButtonPainting)
        radioButtonPotteries = findViewById(R.id.radioButtonPotteries)
        editTextSearchVasa = findViewById(R.id.editTextSearchVasa)
        imageButtonSearch= findViewById(R.id.imageButtonSearch)

        initRecyclerVTenderActivList()

        viewModel.getSubCollectionLocalData()
        viewModel.subCollectionLiveData?.observe(this){
            recyclerViewVaseList.setVaseList(it)
            recyclerViewVaseList.notifyDataSetChanged()
        }

    }

    fun radioButton(){

    }
    private fun initRecyclerVTenderActivList(){
        val recyclerViewVase= findViewById<RecyclerView>(R.id.recyclerViewVase)
        recyclerViewVaseList = VaseAdapter()
        recyclerViewVase?.adapter = recyclerViewVaseList
    }
}