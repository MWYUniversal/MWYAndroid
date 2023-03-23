
package com.owner.recycler_view

import android.app.Application
import com.owner.recycler_view.utils.AppUtils


class RecyclerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppUtils.init(this)
    }
}