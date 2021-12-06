package edu.neu.madcourse.forest_hunter;

import android.widget.ImageView;

public class MapObject {
    protected int posx;
    protected int posy;
    protected ImageView img;
    protected int imageW;
    protected int imageH;

    MapObject(int posx, int posy, ImageView img, int imageW, int imageH) {
        this.posx = posx;
        this.posy = posy;
        this.img = img;
        this.imageW = imageW;
        this.imageH = imageH;
    }

    public int getPosX() {
        return this.posx;
    }

    public int getPosY() {
        return this.posy;
    }

    public void setPosX(int posx) {
        this.posx = posx;
    }

    public void setPosY(int posy) {
        this.posy = posy;
    }

    public int getDistance(MapObject o) {
        int dist;
        dist = (int)Math.sqrt((o.getPosX() - this.getPosX()) * (o.getPosX() - this.getPosX()) + (o.getPosY() - this.getPosY()) * (o.getPosY() - this.getPosY()));
        return dist;
    }

    public ImageView getView() {
        return img;
    }

    public void drawImage(int id) {
        img.setBackground(null);
        img.setImageResource(id);
    }
}
