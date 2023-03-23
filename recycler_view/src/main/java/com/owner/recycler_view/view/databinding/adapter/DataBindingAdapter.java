package com.owner.recycler_view.view.databinding.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.DataBindingHolder;
import com.owner.recycler_view.R;
import com.owner.recycler_view.databinding.ItemMovieBinding;
import com.owner.recycler_view.entity.Movie;
import com.owner.recycler_view.entity.MoviePresenter;


public class DataBindingAdapter extends BaseQuickAdapter<Movie, DataBindingHolder<ItemMovieBinding>> {

    private final MoviePresenter mPresenter = new MoviePresenter();

    @NonNull
    @Override
    protected DataBindingHolder<ItemMovieBinding> onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup parent, int viewType) {
        return new DataBindingHolder<>(R.layout.item_movie, parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull DataBindingHolder<ItemMovieBinding> holder, int position, @Nullable Movie item) {
        if (item == null) return;

        // 获取 Binding
        ItemMovieBinding binding = holder.getBinding();
        binding.setMovie(item);
        binding.setPresenter(mPresenter);
        binding.executePendingBindings();
    }
}
