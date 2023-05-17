package com.owner.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.owner.demo.base.BaseViewBindingActivity
import com.owner.demo.databinding.ActivityMainBinding
import com.owner.demo.viewmodel.MainViewModel
import com.owner.demo.viewmodel.ShareViewModel
import kotlin.random.Random

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>(), View.OnClickListener {
    private val TAG = MainActivity::class.java.simpleName
    private var mainModel: MainViewModel? = null
    var shareModel: ShareViewModel? = null


    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(this).get(MainViewModel::class.java)
        shareModel = ViewModelProvider(this)[ShareViewModel::class.java]
        mBinding.viewModel.setOnClickListener(this)

        mBinding.textContent.text = shareModel!!.name


        /* mainModel!!.name.observe(this) { name ->
             Log.d(TAG, "onCreate() restoreModel update name = $name ")
         }*/

        shareModel!!.clickLiveData.observe(this) {
            Log.d(TAG, "clickLiveData#####: $it")
        }

    }

    fun onRenameClick() {
        var name = "kejiyuanren ".plus(Random.nextInt(100))
        Log.d(TAG, "onRenameClick() called with: name = $name")
        mainModel!!.name.value = name
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.view_model -> {


                shareModel!!.clickLiveData.value = shareModel!!.clickLiveData.value?.plus(1)



                if (shareModel!!.name != "李四") {
                    shareModel!!.name = "李四"
                } else {
                    shareModel!!.name = "张三"
                }

                mBinding.textContent.text = shareModel!!.name
            }
        }
    }
}