package com.owner.rxhttp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.owner.rxhttp.base.BaseViewBindingActivity
import com.owner.rxhttp.databinding.ActivityRxHttpBinding

class RxHttpActivity : BaseViewBindingActivity<ActivityRxHttpBinding>() {
    override fun initBinding(): ActivityRxHttpBinding {
        return ActivityRxHttpBinding.inflate(layoutInflater)
    }

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.button.setOnClickListener {
            RxHttp.get("https://www.wanandroid.com/article/list/0/json")
                .toObservableString()
                .subscribe({ s: String? ->

                    viewBinding.textview.text = s.toString()
                    Log.e("onCreate: ",s.toString() )
                }) { throwable: Throwable? ->

                }
        }


    }
}