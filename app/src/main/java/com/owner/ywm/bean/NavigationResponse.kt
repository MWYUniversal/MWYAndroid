package com.owner.ywm.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 导航数据
  * @CreateDate:     2019/8/26 17:40
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class NavigationResponse(var articles: ArrayList<AriticleResponse>,
                              var cid: Int,
                              var name: String) : Parcelable
