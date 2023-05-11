package com.owner.mokhttp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.owner.mokhttp.databinding.ActivityMainBinding
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.math.log

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.httpSync.setOnClickListener(this)
        mBinding.httpAsync.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.http_sync -> {
                Thread { onNetWork(true) }.start()
            }
            R.id.http_async -> {
                Thread { onNetWork(false) }.start()
            }
        }
    }


    private fun onNetWork(isSync: Boolean) {
        // 1.创建client
        var client = OkHttpClient().newBuilder()
            .cookieJar(CookieJar.NO_COOKIES)
            .callTimeout(10000, TimeUnit.MILLISECONDS)
            // 重试是否允许
            .retryOnConnectionFailure(true)
            // 重定向是否允许
            .followRedirects(true)
            .build()

        // 2.创建request
        var request = Request.Builder()
//            .url("https://www.wanandroid.com/article/list/0/json")
            .url("https://www.wanandroid.com/banner/json")
            .addHeader("Content-Type", "application/json")
            .get()
            .build()
        Log.d(TAG, "请求体$request")


        // 3.构建call对象
        var call = client.newCall(request)

        if (isSync) {
            // 4.1调用call对象的同步请求方法
            var response = call.execute() // response对象中保存的有返回的响应参数

            Log.d(TAG, "响应体${response}")
        }

        if (!isSync) {
            // 4.2调用call对象的异步请求方法
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d(TAG, "onFailure: ");// 失败回调
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d(TAG, "onResponse: ");// 成功回调
                    Log.d(TAG, "响应体${response}")

                }

            })
        }
    }
}