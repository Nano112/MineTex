package graphics;


import java.awt.*;

public class MyColor {

    //Maybe change to a dictionary with colorname and value.
    ColorName color;

    public MyColor(ColorName c)
    {
        this.color = c;
    }


    //Returns ARGB value for a color enum
    public Color getColorValue()
    {
        switch (this.color)
        {

            case TRANSPARENT:return new Color(255,255,255, 0);
            case WHITE:return new Color(255,255,255);
            case BLACK:return new Color(0,0,0);
            default:return new Color(255,0,0);//Rouge pour l'instant comme ca c'est evident si ca foire
        }
    }

    public static ColorName getColorName(Color color)
    {
        //TODO
        //Retourne l'enum avec la distance colorimétrique la plus proche a la couleur ARGB
        //https://fr.wikipedia.org/wiki/Delta_E
        return ColorName.RED;
    }
}
