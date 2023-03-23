package com.owner.recycler_view.view.dragswipe;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.owner.recycler_view.view.home.adapter.HomeAdapter;
import com.owner.recycler_view.R;
import com.owner.recycler_view.base.BaseViewBindingActivity;
import com.owner.recycler_view.databinding.ActivityUniversalRecyclerBinding;
import com.owner.recycler_view.entity.HomeEntity;

import java.util.ArrayList;

public class DragAndSwipeUseActivity extends BaseViewBindingActivity<ActivityUniversalRecyclerBinding> {
    private final ArrayList<HomeEntity> homeItemData = new ArrayList<>();

    @NonNull
    @Override
    public ActivityUniversalRecyclerBinding initBinding() {
        return ActivityUniversalRecyclerBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getViewBinding().titleBar.setTitle("Drag And Swipe");
        getViewBinding().titleBar.setOnBackListener(v -> finish());

        // 设置数据
        homeItemData.add(new HomeEntity("Default Drag And Swipe", DefaultDragAndSwipeActivity.class, R.mipmap.gv_drag_and_swipe, ""));
        homeItemData.add(new HomeEntity("Manual Drag And Swipe", ManualDragAndSwipeUseActivity.class, R.mipmap.gv_drag_and_swipe, ""));
        homeItemData.add(new HomeEntity("Head Drag And Swipe", HeaderDragAndSwipeActivity.class, R.mipmap.gv_drag_and_swipe, ""));
        homeItemData.add(new HomeEntity("Diff Drag And Swipe", DragAndSwipeDifferActivity.class, R.mipmap.gv_drag_and_swipe, ""));

        /*
         * RV适配器
         */
        HomeAdapter mAdapter = new HomeAdapter(homeItemData);


        getViewBinding().rv.setLayoutManager(new LinearLayoutManager(this));
        getViewBinding().rv.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            HomeEntity item = adapter.getItems().get(position);
            if (!item.isSection()) {
                startActivity(new Intent(DragAndSwipeUseActivity.this, item.getActivity()));
            }
        });
    }
}