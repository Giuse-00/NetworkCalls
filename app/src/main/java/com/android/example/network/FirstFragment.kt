package com.android.example.network

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.android.example.network.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        retrieveDetails()

        return binding.root
    }

    private fun setDetails(result : Data){
        binding.textView2.text = getString(R.string.names, result.message)
    }

    private fun retrieveDetails(){
        lifecycleScope.launch {
            try {
                val details = instanceRetrofit().apiService.getDetails()
                setDetails(details)
            }catch (e:Exception){
                Log.v("First Fragment", "ERROR ${e.message}")
            }
        }
    }
}