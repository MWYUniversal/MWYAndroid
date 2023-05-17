package com.owner.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel:ViewModel() {
    var name = "张三"

    var clickLiveData = MutableLiveData<Int>(0)



}