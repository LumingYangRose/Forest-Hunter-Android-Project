package edu.neu.madcourse.forest_hunter;

import android.widget.ImageView;

public class Coins extends MapObject {
    private int coins;

    public Coins(int posx, int posy, ImageView img, int imageW, int imageH) {
        super(posx, posy, img, imageW, imageH);
        coins = 0;
    }

    public Coins(int posx, int posy, ImageView img, int imageW, int imageH, int coins) {
        super(posx, posy, img, imageW, imageH);
        this.coins = coins;
    }

    public void plusCoins() {
        coins++;
    }

    public int getCoins() {
        return coins;
    }
}
