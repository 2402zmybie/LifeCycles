package com.hr.lifecycles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    lateinit var elapsedTime:MutableLiveData<Long>


    fun getMyElapsedTime():MutableLiveData<Long> {
        if(elapsedTime == null) {
            elapsedTime = MutableLiveData()
            elapsedTime.value = 0
        }
        return elapsedTime;
    }

    fun setElapsedTime(time:Long) {
        elapsedTime.value = time
    }
}