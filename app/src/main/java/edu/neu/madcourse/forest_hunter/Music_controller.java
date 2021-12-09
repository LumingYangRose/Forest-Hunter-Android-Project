package edu.neu.madcourse.forest_hunter;

import androidx.appcompat.app.AppCompatActivity;

public class Music_controller {
    public static Music bgm;
    public static int current_bgm_index = 0;
    public Music_controller(AppCompatActivity activity)
    {
        bgm = new Music(activity);
    }
}
