package com.example.demoapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.demoapplication.app.MyApplication
import com.example.demoapplication.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Sajid.
 */
@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository : MainRepository, application: Application) : AndroidViewModel(application) {
    fun test(){

    }
}