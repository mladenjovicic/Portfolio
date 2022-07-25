package com.mladenjovicic.portfolio.ui.vase.vaseShow

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
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.mladenjovicic.portfolio.R
import com.mladenjovicic.portfolio.ViewModelsProviderUtils

class VaseShowFragment : Fragment() {

    companion object {
        fun newInstance() = VaseShowFragment()
    }

    private lateinit var viewModel: VaseShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.vase_show_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelsProviderUtils.getVaseShowViewModel(this)
        val textViewVaseName = view?.findViewById<TextView>(R.id.textViewVaseName)
        val textViewVaseDesription = view?.findViewById<TextView>(R.id.textViewVaseDesription)
        var vasaId = getActivity()?.intent?.extras?.get("vaseId") as String


        viewModel.getVasaDetailes(vasaId)
        viewModel.vaseDetalisLiveData!!.observe(requireActivity()){
            textViewVaseName?.text = it.name
            textViewVaseDesription?.text = it.description
            DownloadImageFromInternet(requireView().findViewById(R.id.imageViewVase)).execute(it.url)}

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