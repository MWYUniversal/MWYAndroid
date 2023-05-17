package com.owner.demo.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(savedStateHandle: SavedStateHandle):ViewModel() {
    companion object {
        private const val USER = "user"
        private const val NAME = "name"
        private val TAG: String = MainViewModel::class.java.simpleName
    }



    val name = MutableLiveData<String?>()

    init {
        //获取 savedStateHandle 中的 bundle,进行键值对获取
        val restoreBundle = savedStateHandle.get<Bundle>(USER)
        if (restoreBundle != null) {
            if (restoreBundle.containsKey(NAME)) {
                name.value = restoreBundle.getString(NAME)
                Log.d(TAG, "init() savedStateHandle restore name = ${name.value}")
            } else {
                name.value = null
            }
        }

        //退到后台，或者屏幕旋转等，保存状态
        savedStateHandle.setSavedStateProvider(USER) {
            if (name.value != null) {
                Log.d(TAG, "init() savedStateHandle saveState name = ${name.value}")
                bundleOf(NAME to name.value)
            } else {
                Bundle()
            }
        }
    }
}


