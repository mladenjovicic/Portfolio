package com.mladenjovicic.portfolio.ui.vase.vaseEdit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ViewModelsProviderUtils

class VaseEditFragment : Fragment() {

    companion object {
        fun newInstance() = VaseEditFragment()
    }

    private lateinit var viewModel: VaseEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vase_edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelsProviderUtils.getVaseEditViewModel(this)
        // TODO: Use the ViewModel
    }

}