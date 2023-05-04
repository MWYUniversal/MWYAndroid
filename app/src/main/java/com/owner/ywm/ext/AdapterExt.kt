package com.owner.ywm.ext


/**
 * 时间　: 2020/4/16
 * 描述　:
 */

/**
 * 给adapter拓展的，防止重复点击item
 */
var adapterLastClickTime = 0L

// todo
/*  fun BaseQuickAdapter<*, *>.setNbOnItemClickListener(interval: Long = 1000, action: (adapter: BaseQuickAdapter<*, *>, view: View, position: Int) -> Unit) {

 setOnItemClickListener { adapter, view, position ->
       val currentTime = System.currentTimeMillis()
       if (adapterLastClickTime != 0L && (currentTime - adapterLastClickTime < interval)) {
           return@setOnItemClickListener
       }
       adapterLastClickTime = currentTime
       action(adapter,view,position)
   }
}*/


/**
 * 给adapter拓展的，防止重复点击item
 */
var adapterChildLastClickTime = 0L
/*  fun BaseQuickAdapter<*, *>.setNbOnItemChildClickListener(interval: Long = 1000,action: (adapter: BaseQuickAdapter<*, *>, view: View, position: Int) -> Unit) {
  addOnItemChildClickListener{ adapter, view, position ->
        val currentTime = System.currentTimeMillis()
        if (adapterChildLastClickTime != 0L && (currentTime - adapterChildLastClickTime < interval)) {
            return@addOnItemChildClickListener
        }
        adapterChildLastClickTime = currentTime
        action(adapter,view,position)
    }
}*/