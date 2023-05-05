package com.owner.banner.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.owner.banner.R;
import com.owner.banner.bean.DataBean;
import com.owner.banner.viewholder.ImageHolder;
import com.owner.banner.viewholder.TitleHolder;
import com.owner.banner.viewholder.VideoHolder;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.util.BannerUtils;

import java.util.List;

/**
 * 自定义布局,多个不同UI切换
 */
public class MultipleTypesAdapter extends BannerAdapter<DataBean, RecyclerView.ViewHolder> {
    private Context context;
    private SparseArray<RecyclerView.ViewHolder> mVHMap = new SparseArray<>();

    public MultipleTypesAdapter(Context context, List<DataBean> mDatas) {
        super(mDatas);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new ImageHolder(BannerUtils.getView(parent, R.layout.banner_image));
            case 2:
                return new VideoHolder(BannerUtils.getView(parent, R.layout.banner_video));
            case 3:
                return new TitleHolder(BannerUtils.getView(parent, R.layout.banner_title));
        }
        return new ImageHolder(BannerUtils.getView(parent, R.layout.banner_image));
    }

    @Override
    public int getItemViewType(int position) {
        //先取得真实的position,在获取实体
//        return getData(getRealPosition(position)).viewType;
        //直接获取真实的实体
        return getRealData(position).viewType;
        //或者自己直接去操作集合
//        return mDatas.get(getRealPosition(position)).viewType;
    }

    @Override
    public void onBindView(RecyclerView.ViewHolder holder, DataBean data, int position, int size) {
        int viewType = holder.getItemViewType();
        switch (viewType) {
            case 1:
                ImageHolder imageHolder = (ImageHolder) holder;
                mVHMap.append(position,imageHolder);
                imageHolder.imageView.setImageResource(data.imageRes);
                break;
            case 2:
                VideoHolder videoHolder = (VideoHolder) holder;
                mVHMap.append(position,videoHolder);

                ExoPlayer player = new ExoPlayer.Builder(context).build();
                videoHolder.player.setPlayer(player);

                //3. 设置数据源
                //音频
//        val mediaItem = MediaItem.fromUri(" https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
                MediaItem mediaItem =  MediaItem.fromUri(" https://vd7.bdstatic.com/mda-maunc8q8gpwgjts8/sc/cae_h264_nowatermark/1611907885/mda-maunc8q8gpwgjts8.mp4?v_from_s=hkapp-haokan-hna&auth_key=1682653767-0-0-8e29e28c8718b03ac65b3370136a9a8d&bcevod_channel=searchbox_feed&pd=1&cd=0&pt=3&logid=1167717116&vid=11220038343555649881&abtest=109159_2&klogid=1167717116&sdk_xcdn=1");
                player.setMediaItem(mediaItem);
                //4.当Player处于STATE_READY状态时，进行播放
                player.setPlayWhenReady(true);
                //5. 调用prepare开始加载准备数据，该方法时异步方法，不会阻塞ui线程
                player.prepare();
                break;
            case 3:
                TitleHolder titleHolder = (TitleHolder) holder;
                mVHMap.append(position,titleHolder);
                titleHolder.title.setText(data.title);
                titleHolder.title.setBackgroundColor(Color.parseColor(DataBean.getRandColor()));
                break;
        }
    }

    public SparseArray<RecyclerView.ViewHolder> getVHMap() {
        return mVHMap;
    }


}
