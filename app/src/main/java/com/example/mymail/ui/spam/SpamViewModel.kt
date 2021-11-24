package com.example.mymail.ui.spam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpamViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is spam Fragment"
    }
    val text: LiveData<String> = _text
}