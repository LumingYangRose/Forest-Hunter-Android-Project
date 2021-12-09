package edu.neu.madcourse.forest_hunter;

import android.widget.ImageView;

public class Life extends MapObject {

    private int lives;
    private final int STARTINGLIVES = 3;

    public Life(int posx, int posy, ImageView img, int imageW, int imageH) {
        super(posx, posy, img, imageW, imageH);
        lives = STARTINGLIVES;
    }

    public void reduceLives() {
        lives--;
    }

    public int getLives() {
        return lives;
    }
}
