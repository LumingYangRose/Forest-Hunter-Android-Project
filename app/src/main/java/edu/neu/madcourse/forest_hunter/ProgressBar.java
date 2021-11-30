package edu.neu.madcourse.forest_hunter;

import android.widget.ImageView;

public class ProgressBar extends MapObject {
    private int current_progress;

    public ProgressBar(int posx, int posy, ImageView img, int imageW, int imageH) {
        super(posx, posy, img, imageW, imageH);
        current_progress = 0;
    }

    public void progressing() {
        current_progress++;
    }

    public int getProgress() {
        return current_progress;
    }
}
