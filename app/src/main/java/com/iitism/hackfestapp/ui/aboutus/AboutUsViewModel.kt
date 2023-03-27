package com.iitism.hackfestapp.ui.aboutus

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutUsViewModel(
    private val repository: AboutUsRepository
) : ViewModel() {

    val organizerList = MutableLiveData<List<AboutUsModel>>()


    suspend fun getAllOrganizers(){
        val response = repository.getAllOrganizers()

        if (response.isSuccessful){
            organizerList.postValue(response.body())
        }
        else{
            Log.d("tag","Retrofit : Bad Response")
        }
    }



}