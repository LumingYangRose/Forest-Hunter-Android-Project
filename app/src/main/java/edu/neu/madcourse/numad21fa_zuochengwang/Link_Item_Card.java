package edu.neu.madcourse.numad21fa_zuochengwang;

public class Link_Item_Card {
    private final int image;
    private final String web_Name;
    private final String URL;

    public Link_Item_Card(int image, String web_Name, String URL) {
        this.image = image;
        this.web_Name = web_Name;
        this.URL = URL;
    }

    public int getImage() {
        return image;
    }

    public String getURL() {
        return URL;}

    public String getWebName() {
        return web_Name;
    }

}
