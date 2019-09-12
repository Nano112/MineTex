import Exceptions.BadFormatting;
import Exceptions.IncorrectBracketException;
import org.scilab.forge.jlatexmath.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
        public static void main(String[] args) throws IOException, IncorrectBracketException, BadFormatting {

                ExpressionTree test = new ExpressionTree("Ceci est un + test = 2");
                test.parse();
                test.Display();
                TeXFormula formula = new TeXFormula("\\sum_0^\\infty x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}");
                BufferedImage im = (BufferedImage)formula.createBufferedImage(TeXConstants.STYLE_DISPLAY,20,new Color(0,0,0),new Color(255,255,255));
                ImageIO.write(im, "png", new File("image.png"));
        }
}

