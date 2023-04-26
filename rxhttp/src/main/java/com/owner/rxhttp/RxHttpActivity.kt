package com.owner.rxhttp

import android.os.Bundle
import com.owner.rxhttp.base.BaseViewBindingActivity
import com.owner.rxhttp.databinding.ActivityRxHttpBinding

class RxHttpActivity : BaseViewBindingActivity<ActivityRxHttpBinding>() {
    override fun initBinding(): ActivityRxHttpBinding {
        return ActivityRxHttpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}