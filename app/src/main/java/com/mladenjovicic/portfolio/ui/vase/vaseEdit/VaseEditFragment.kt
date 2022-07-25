package com.mladenjovicic.portfolio.ui.vase.vaseEdit

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
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
        var vasaId = getActivity()?.intent?.extras?.get("vaseId") as String
        val editTextVasaName = view?.findViewById<EditText>(R.id.editTextVasaName)
        val editTextVasaDescription = view?.findViewById<EditText>(R.id.editTextVasaDescription)
        val btnSave = view?.findViewById<Button>(R.id.btnSave)!!.setOnClickListener {

            viewModel.updateVasaID(editTextVasaName!!.text.toString(), editTextVasaDescription!!.text.toString(), vasaId)
            Toast.makeText(requireContext(), "data updated", Toast.LENGTH_SHORT)
        }

        viewModel.getVasaDetailes(vasaId)
        viewModel.vaseDetalisLiveData!!.observe(requireActivity()){
            editTextVasaName?.setText(it.name)
            editTextVasaDescription?.setText(it.description)
            DownloadImageFromInternet(requireView().findViewById(R.id.imageViewEditVase)).execute(it.url)}

    }




    @SuppressLint("StaticFieldLeak")
    @Suppress("DEPRECATION")
    private inner class DownloadImageFromInternet(var imageView: ImageView) : AsyncTask<String, Void, Bitmap?>() {
        init {
            Toast.makeText(requireContext(), "Please wait, it may take a few minute...",     Toast.LENGTH_SHORT).show()
        }
        override fun doInBackground(vararg urls: String): Bitmap? {
            val imageURL = urls[0]
            var image: Bitmap? = null
            try {
                val `in` = java.net.URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)
            }
            catch (e: Exception) {
                Log.e("Error Message", e.message.toString())
                e.printStackTrace()
            }
            return image
        }
        override fun onPostExecute(result: Bitmap?) {
            imageView.setImageBitmap(result)
        }
    }

}