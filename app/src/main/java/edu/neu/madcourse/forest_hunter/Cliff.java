package edu.neu.madcourse.forest_hunter;

import android.widget.ImageView;

public class Cliff extends MovingObject {

    public Cliff(int posx, int posy, ImageView img, int imageW, int imageH, int vx, int vy) {
        super(posx, posy, img, imageW, imageH, vx, vy);
    }

    public boolean inRange(Character character) {
        if (Math.abs(this.posx - character.posx) < this.imageW / 2) {
            return true;
        } else {
            return false;
        }
    }
}
