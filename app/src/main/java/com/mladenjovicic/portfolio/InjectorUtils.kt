package com.mladenjovicic.portfolio

import android.content.Context
import com.mladenjovicic.portfolio.Data.LocalData.DatabaseService
import com.mladenjovicic.portfolio.Data.Repository.LoadingRepository
import com.mladenjovicic.portfolio.Data.Repository.Local.LocalRepository
import com.mladenjovicic.portfolio.Data.Repository.VaseRepository
import com.mladenjovicic.portfolio.Data.ServerData.RetrofitInstance
import com.mladenjovicic.portfolio.Data.ServerData.RetrofitService
import com.mladenjovicic.portfolio.ui.loading.LoadingViewModel
import com.mladenjovicic.portfolio.ui.main.MainViewModel
import com.mladenjovicic.portfolio.ui.vase.vaseEdit.VaseEditViewModel
import com.mladenjovicic.portfolio.ui.vase.vaseShow.VaseShowViewModel

object InjectorUtils {
    fun getContext(): Context = PortfolioApplication.instance.applicationContext

    private val retrofitInstance by lazy { RetrofitInstance() }

    private val retrofitService by lazy { RetrofitService(retrofitInstance) }

    private fun getDatabaseService() = DatabaseService.getInstance(getContext())

    private val localRepository by lazy { LocalRepository(getDatabaseService()) }

    private val loadingRepository by lazy { LoadingRepository(retrofitService, localRepository) }

    fun getLoadingViewModel() = LoadingViewModel(loadingRepository)

    private val vaseRepository by lazy { VaseRepository(retrofitService, localRepository) }

    fun getMainViewModel() = MainViewModel(vaseRepository)

    fun getVaseEditViewModel() = VaseEditViewModel(vaseRepository)

    fun getVaseShowViewModel() = VaseShowViewModel(vaseRepository)


}