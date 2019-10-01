package structures;

import java.awt.image.BufferedImage;

public class TileImage {
    public int x;
    public int y;
    public BufferedImage image;

    public TileImage(int x, int y, BufferedImage image)
    {
        this.x = x;
        this.y = y;
        this.image = image;
    }
}