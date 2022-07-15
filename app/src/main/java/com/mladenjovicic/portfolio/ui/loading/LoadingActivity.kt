package com.mladenjovicic.portfolio.ui.loading

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.CollectionTreeDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.SubCollectionTreeDBModel
import com.mladenjovicic.portfolio.Data.Model.DB.TreeDBModel
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ViewModelsProviderUtils
import com.mladenjovicic.portfolio.ui.main.MainActivity

class LoadingActivity : AppCompatActivity() {
    private lateinit var viewModel: LoadingViewModel
    private lateinit var textViewLoading:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        viewModel = ViewModelsProviderUtils.getLoadingViewModel(this)
        textViewLoading=findViewById(R.id.TextViewLoading)
        getCollectionJSON()
        getTreeJSON()
    }

    fun getCollectionJSON(){
        viewModel.getCollectionJSON()
        viewModel.requestState.observe(this) {
            if(it.pending){
                Log.e("Loading", "retrofit request is in progress, show loading spinner")
                textViewLoading.text="Loading collection"
            }
            if(it.successful){
                println("dev002")
                textViewLoading.text="Success getting collection"

                Log.e("Success", "retrofit request is successful")
                viewModel.collectionAPIModelLiveData.observe(this) {
                    if(it.collection.isNotEmpty()) {
                        Log.e("Retrofit fetched list", "update adapter! ${it.collection.toList()}")
                        for (i in 0..it.collection.size-1) {
                            viewModel.insertCollectionLocalData(CollectionDBModel(it.collection[i].Id!!,it.collection[i].Name, it.collection[i].Type,it.collection[i].Url,it.collection[i].Description))
                        }
                    }else
                        Log.e("List is empty or null", "update view")
                        textViewLoading.text="Failed getting collection list is empty"

                }
            }else{
                textViewLoading.text="Failed getting collection ${it.errorMessage}"
                Toast.makeText(this, "Error ${it.errorMessage}", Toast.LENGTH_SHORT)
            }
        }
    }

    fun getTreeJSON(){
        viewModel.getTreeJSON()
        viewModel.requestState.observe(this) {
            if(it.pending){
                textViewLoading.text="Loading collection"
                Log.e("Loading", "retrofit request is in progress, show loading spinner")
            }
            if(it.successful){
                textViewLoading.text="Success getting tree"
                Log.e("Success", "retrofit request is successful")
                viewModel.treeAPIModelLiveData.observe(this) { treeRespons ->
                    if(treeRespons.collection.isNotEmpty()) {
                        viewModel.insertTreeLocalData(TreeDBModel(treeRespons.Id!!,treeRespons.Name, treeRespons.Type))
                        Log.e("Retrofit fetched list", "update adapter! ${treeRespons.collection.toList()}")
                        for (i in 0 until treeRespons.collection.size) {
                            viewModel.insertCollectionTreeLocalData(CollectionTreeDBModel(treeRespons.collection[i].Id,treeRespons.collection[i].Name, treeRespons.collection[i].Type, treeRespons.Id))
                            for (a in 0 until treeRespons.collection[i].TreeCollection.size){
                                viewModel.insertSubCollectionTreeLocalData(SubCollectionTreeDBModel(treeRespons.collection[i].TreeCollection[a].Id,treeRespons.collection[i].TreeCollection[a].Name, treeRespons.collection[i].TreeCollection[a].Type, treeRespons.collection[i].Id))
                            }
                        }
                    }else
                        Log.e("List is empty or null", "update view")
                        textViewLoading.text="Failed getting tree list is empty"
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                textViewLoading.text="Failed getting tree ${it.errorMessage}"
                Toast.makeText(this, "Error ${it.errorMessage}", Toast.LENGTH_SHORT)
            }
        }
    }

}