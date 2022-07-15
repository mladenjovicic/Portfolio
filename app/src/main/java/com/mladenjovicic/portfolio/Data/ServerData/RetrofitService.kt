package com.mladenjovicic.portfolio.Data.ServerData

import androidx.lifecycle.MutableLiveData
import com.mladenjovicic.portfolio.Data.Model.API.*
import com.mladenjovicic.portfolio.Data.Model.RequestState
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class RetrofitService(private val retrofitInstance: RetrofitInstance) {

    private val retrofitInterface = retrofitInstance.getRetrofit().create(RetrofitInterface::class.java)

    fun getCollectionJSON(
        liveData: MutableLiveData<CollectionAPIModel>,
        requestState: MutableLiveData<RequestState>
    ){
        requestState.postValue(RequestState.pending)
        val call = retrofitInterface.getCollection()
        call.enqueue(object : Callback<CollectionAPIModel> {
            override fun onResponse(
                call: Call<CollectionAPIModel>,
                response: Response<CollectionAPIModel>
            ) {
                val body = response.body()
                if (body != null) {
                    liveData.postValue(body)
                    requestState.postValue(RequestState.success)
                } else
                    requestState.postValue(RequestState.failed)

            }

            override fun onFailure(call: Call<CollectionAPIModel>, t: Throwable) {
                requestState.postValue(
                    RequestState(
                        pending = false,
                        successful = false,
                        errorMessage = t.message.toString()
                    )
                )
            }
        })
    }

    fun getTreeJSON(
        liveData: MutableLiveData<TreeAPIModel>,
        requestState: MutableLiveData<RequestState>
    ){
        requestState.postValue(RequestState.pending)
        val call = retrofitInterface.getTree()
        call.enqueue(object : Callback<TreeAPIModel> {
            override fun onResponse(
                call: Call<TreeAPIModel>,
                response: Response<TreeAPIModel>
            ) {
                val body = response.body()
                if (body != null) {
                    liveData.postValue(body)
                    requestState.postValue(RequestState.success)
                } else
                    requestState.postValue(RequestState.failed)

            }

            override fun onFailure(call: Call<TreeAPIModel>, t: Throwable) {
                requestState.postValue(
                    RequestState(
                        pending = false,
                        successful = false,
                        errorMessage = t.message.toString()
                    )
                )
            }
        })
    }

}