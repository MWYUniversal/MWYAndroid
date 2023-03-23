package com.owner.recycler_view.view.databinding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.owner.recycler_view.base.BaseViewBindingActivity;
import com.owner.recycler_view.databinding.ActivityUniversalRecyclerBinding;
import com.owner.recycler_view.entity.Movie;
import com.owner.recycler_view.utils.Tips;
import com.owner.recycler_view.view.databinding.adapter.DataBindingAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class DataBindingUseActivity extends BaseViewBindingActivity<ActivityUniversalRecyclerBinding> {

    private final DataBindingAdapter adapter = new DataBindingAdapter();

    @NonNull
    @Override
    public ActivityUniversalRecyclerBinding initBinding() {
        return ActivityUniversalRecyclerBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getViewBinding().titleBar.setTitle("DataBinding Use");
        getViewBinding().titleBar.setOnBackListener(v -> finish());


        getViewBinding().rv.setLayoutManager(new LinearLayoutManager(this));
        getViewBinding().rv.setAdapter(adapter);


        //item 点击事件
        adapter.setOnItemClickListener((movieBaseQuickAdapter, view, position) -> {
            Tips.show("onItemClick: " + position);
        });

        //设置数据
        adapter.submitList(genData());
    }

    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Chad " + i;
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(movie);
        }
        return list;
    }
}
