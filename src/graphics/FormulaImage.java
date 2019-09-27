package graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FormulaImage {
    //Class to generate and edit a image
    BufferedImage image;
    int width;
    int height;

    MyColor backGround;
    MyColor foreGround;
    MyColor highGround;


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






}
