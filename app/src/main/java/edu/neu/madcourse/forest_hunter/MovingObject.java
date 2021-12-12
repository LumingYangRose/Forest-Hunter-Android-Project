package edu.neu.madcourse.forest_hunter;

import android.widget.ImageView;

public class MovingObject extends MapObject {
    protected int vx;
    protected int vy;

    public MovingObject(int posx, int posy, ImageView img, int imageW, int imageH, int vx, int vy) {
        super(posx, posy, img, imageW, imageH);
        this.vx = vx;
        this.vy = vy;
    }

    public void setVX(int vx) {
        this.vx = vx;
    }

    public void setVY(int vy) {
        this.vy = vy;
    }

    public int getSpeed() {
        int speed = (int) Math.sqrt(vx * vx + vy * vy);
        return speed;
    }

    public void drawImage() {
        this.posx += vx;
        this.posy += vy;
        img.setBackground(null);
        //img.setImageResource(id);
    }
}
