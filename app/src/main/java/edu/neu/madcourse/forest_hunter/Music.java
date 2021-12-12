package edu.neu.madcourse.forest_hunter;

import android.media.MediaPlayer;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Music {

    MediaPlayer music_player;
    ArrayList<Integer> bgm_list;
    int current_bgm_index;
    AppCompatActivity activity;

    public Music(AppCompatActivity activity) {
        bgm_list = new ArrayList<>();
        bgm_list.add(R.raw.bgm1);
        bgm_list.add(R.raw.bgm2);
        bgm_list.add(R.raw.bgm3);
        bgm_list.add(R.raw.bgm4);
        bgm_list.add(R.raw.bgm5);
        current_bgm_index = 0;
        this.activity = activity;

    }

    public void play_music() {

        if (music_player == null) {
            music_player = MediaPlayer.create(activity, bgm_list.get(current_bgm_index));
            music_player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    music_player.start();
                }
            });
        }
        music_player.start();
    }

    public void play_music(int index) {

        if (music_player == null) {
            music_player = MediaPlayer.create(activity, bgm_list.get(index));
            music_player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    music_player.start();
                }
            });
        }
        music_player.start();
    }

    public void play_next() {
        if (current_bgm_index < 4) {
            current_bgm_index++;
            this.stop();
            this.play_music();
        } else if (current_bgm_index == 4) {
            this.stop();
            current_bgm_index++;
        } else if (current_bgm_index == 5) {
            current_bgm_index = 0;
            this.stop();
            this.play_music();
        }
    }

    public void pause() {
        if (music_player != null) {
            music_player.pause();
        }
    }

    public void stop() {
        stop_Player();
    }

    public void stop_Player() {
        if (music_player != null) {
            music_player.release();
            music_player = null;
        }
    }
}
