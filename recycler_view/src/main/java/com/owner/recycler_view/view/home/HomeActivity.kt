package com.owner.recycler_view.view.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.owner.recycler_view.view.emptyview.EmptyViewUseActivity
import com.owner.recycler_view.view.headerfooter.HeaderAndFooterUseActivity
import com.owner.recycler_view.view.home.adapter.HomeAdapter
import com.owner.recycler_view.view.home.adapter.HomeTopHeaderAdapter
import com.owner.recycler_view.view.itemclick.ItemClickActivity
import com.owner.recycler_view.view.loadmore.AutoLoadMoreRefreshUseActivity
import com.owner.recycler_view.view.loadmore.NoAutoAutoLoadMoreRefreshUseActivity
import com.owner.recycler_view.view.scene.GroupDemoActivity
import com.owner.recycler_view.view.upfetch.UpFetchUseActivity
import com.chad.library.adapter.base.QuickAdapterHelper
import com.owner.recycler_view.R
import com.owner.recycler_view.databinding.ActivityHomeBinding
import com.owner.recycler_view.entity.HomeEntity
import com.owner.recycler_view.view.animation.AnimationUseActivity
import com.owner.recycler_view.view.databinding.DataBindingUseActivity
import com.owner.recycler_view.view.differ.DifferActivity
import com.owner.recycler_view.view.dragswipe.DragAndSwipeUseActivity


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    /**
     * RV适配器
     */
    private val homeAdapter by lazy(LazyThreadSafetyMode.NONE) {
        HomeAdapter(homeItemData)
    }

    private val helper by lazy(LazyThreadSafetyMode.NONE) {
        QuickAdapterHelper.Builder(homeAdapter)
            .build()
            .addBeforeAdapter(HomeTopHeaderAdapter())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 从 QuickAdapterHelper 获取 adapter，设置给 RecycleView
        binding.recyclerView.adapter = helper.adapter

        // item 点击事件
        homeAdapter.setOnItemClickListener { adapter, _, position ->
            val item = adapter.items[position]
            if (!item.isSection) {
                startActivity(Intent(this, item.activity))
            }
        }
    }

    private val homeItemData: ArrayList<HomeEntity>
        get() = arrayListOf(
            HomeEntity(sectionTitle = "BaseQuickAdapter 基础功能"),
            HomeEntity("Animation", AnimationUseActivity::class.java, R.mipmap.gv_animation),
            HomeEntity(
                "Header/Footer", HeaderAndFooterUseActivity::class.java, R.mipmap.gv_header_and_footer),
            HomeEntity("EmptyView", EmptyViewUseActivity::class.java, R.mipmap.gv_empty),
            HomeEntity("ItemClick", ItemClickActivity::class.java, R.mipmap.gv_item_click),
            HomeEntity("DataBinding", DataBindingUseActivity::class.java, R.mipmap.gv_databinding),
            HomeEntity("DiffUtil", DifferActivity::class.java, R.mipmap.gv_databinding),

//
            HomeEntity(sectionTitle = "功能模块"),
            HomeEntity(
                "LoadMore(Auto)",
                AutoLoadMoreRefreshUseActivity::class.java,
                R.mipmap.gv_pulltorefresh
            ),
            HomeEntity(
                "LoadMore",
                NoAutoAutoLoadMoreRefreshUseActivity::class.java,
                R.mipmap.gv_pulltorefresh
            ),
            HomeEntity(
                "DragAndSwipe",
                DragAndSwipeUseActivity::class.java,
                R.mipmap.gv_drag_and_swipe
            ),
            HomeEntity("UpFetch", UpFetchUseActivity::class.java, R.drawable.gv_up_fetch),


            HomeEntity(sectionTitle = "场景演示"),
            HomeEntity(
                "Group（ConcatAdapter）",
                GroupDemoActivity::class.java,
                R.mipmap.gv_animation
            ),
        )
}