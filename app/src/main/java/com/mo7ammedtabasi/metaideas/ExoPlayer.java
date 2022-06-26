package com.mo7ammedtabasi.metaideas;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;

public class ExoPlayer extends AppCompatActivity {

    PlayerView playerView;
    SimpleExoPlayer simpleExoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);

        playerView=findViewById(R.id.playerView);
        simpleExoPlayer=new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(simpleExoPlayer);
        Uri uri= RawResourceDataSource.buildRawResourceUri(R.raw.youcan);
        MediaSource mediaSource=buildMediaSource(uri);
        simpleExoPlayer.prepare(mediaSource);
        simpleExoPlayer.play();
    }

    MediaSource buildMediaSource(Uri uri){
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,"exoplayer");
        return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
    }

    @Override
    protected void onStop() {
        simpleExoPlayer.stop();
        finish();
        super.onStop();
    }
}