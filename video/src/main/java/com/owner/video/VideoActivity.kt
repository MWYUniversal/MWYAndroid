package com.owner.video

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView


class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val playerView = findViewById<StyledPlayerView>(R.id.player_view)

        //1. 创建播放器
//       var  player = StyledPlayerView(this)

        var player = ExoPlayer.Builder(this.application).build()

        //2. 播放器和播放器容器绑定
        playerView.player = player

        //3. 设置数据源
        //音频
//        val mediaItem = MediaItem.fromUri(" https://storage.googleapis.com/exoplayer-test-media-0/play.mp3")
        val mediaItem = MediaItem.fromUri(" https://vd7.bdstatic.com/mda-maunc8q8gpwgjts8/sc/cae_h264_nowatermark/1611907885/mda-maunc8q8gpwgjts8.mp4?v_from_s=hkapp-haokan-hna&auth_key=1682653767-0-0-8e29e28c8718b03ac65b3370136a9a8d&bcevod_channel=searchbox_feed&pd=1&cd=0&pt=3&logid=1167717116&vid=11220038343555649881&abtest=109159_2&klogid=1167717116&sdk_xcdn=1")
        player.setMediaItem(mediaItem)

        //4.当Player处于STATE_READY状态时，进行播放
        player.playWhenReady = true

        //5. 调用prepare开始加载准备数据，该方法时异步方法，不会阻塞ui线程
        player.prepare()
    }
}