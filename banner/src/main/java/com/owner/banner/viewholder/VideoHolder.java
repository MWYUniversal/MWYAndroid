package com.owner.banner.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.owner.banner.R;

public class VideoHolder extends RecyclerView.ViewHolder {
    public StyledPlayerView player;

    public VideoHolder(@NonNull View view) {
        super(view);
        player = view.findViewById(R.id.player);
    }
}
