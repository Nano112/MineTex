package graphics;

import Exceptions.UnknownCharacter;
import Exceptions.UnknownTile;
import structures.TileImage;
import tiles.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FormulaImage {
    //Class to generate and edit a image
    public BufferedImage image;
    int width;
    int height;

    MyColor backGround;
    MyColor foreGround;
    MyColor highGround;

    public FormulaImage(int w, int h )
    {
        this.width = w;
        this.height = h;
        this.backGround = new MyColor(ColorName.WHITE);
        this.foreGround = new MyColor(ColorName.BLACK);

        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.setColor(this.backGround);
    }

    public FormulaImage(int w, int h, MyColor bg)
    {
        this.width = w;
        this.height = h;
        this.backGround = bg;
        this.foreGround = new MyColor(ColorName.BLACK);

        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.setColor(this.backGround);
    }

    public FormulaImage(int w, int h, MyColor bg, MyColor fg)
    {
        this.width = w;
        this.height = h;
        this.backGround = bg;
        this.foreGround = fg;

        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.setColor(this.backGround);
    }

    public void setColor(MyColor c)
    {
        Color bg = this.backGround.getColorValue();
        if (this.backGround.color.equals(ColorName.TRANSPARENT))
        {
            //Je fait ca comme le "this.image.setRGB" ne parait pas supporter le canal Alpha
            bg = new Color(255,255,255);//Donc Blanc me parait la couleur logique
        }
        for (int x = 0; x < this.width ; x++) {
            for (int y = 0; y < this.height ; y++) {
                this.image.setRGB(x,y,bg.getRGB());
            }
        }
    }

    public void setPixel(int x, int y)
    {
        this.image.setRGB(x,y,this.foreGround.getColorValue().getRGB());
    }

    public void addTiles(ArrayList<TileImage> tileImages)
    {
        Graphics graphics = this.image.getGraphics();
        for(TileImage tile: tileImages)
        {
            graphics.drawImage(tile.image,tile.x,tile.y,null);
        }
    }
}