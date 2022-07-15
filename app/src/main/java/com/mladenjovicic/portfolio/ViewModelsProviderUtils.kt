package com.mladenjovicic.portfolio

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mladenjovicic.portfolio.ui.loading.LoadingViewModel
import com.mladenjovicic.portfolio.ui.main.MainViewModel
import com.mladenjovicic.portfolio.ui.vase.vaseEdit.VaseEditFragment
import com.mladenjovicic.portfolio.ui.vase.vaseEdit.VaseEditViewModel
import com.mladenjovicic.portfolio.ui.vase.vaseShow.VaseShowFragment
import com.mladenjovicic.portfolio.ui.vase.vaseShow.VaseShowViewModel

object ViewModelsProviderUtils {

    fun getLoadingViewModel(activity: FragmentActivity) =
        ViewModelProvider(activity, LoadingViewModelFactory()).get(LoadingViewModel::class.java)

    class LoadingViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T { return InjectorUtils.getLoadingViewModel() as T }
    }

    fun getMainViewModel(activity: FragmentActivity) =
        ViewModelProvider(activity, MainViewModelFactory()).get(MainViewModel::class.java)

    class MainViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T { return InjectorUtils.getMainViewModel() as T }
    }

    fun getVaseEditViewModel(activity: VaseEditFragment)=
        ViewModelProvider(activity, GetVaseEditViewModelFactory()).get(VaseEditViewModel::class.java)

    class GetVaseEditViewModelFactory:ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T { return InjectorUtils.getVaseEditViewModel() as T }
    }

    fun getVaseShowViewModel(activity: VaseShowFragment)=
        ViewModelProvider(activity, GetVaseShowViewModelFactory()).get(VaseShowViewModel::class.java)

    class GetVaseShowViewModelFactory:ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T { return InjectorUtils.getVaseShowViewModel() as T }
    }
}