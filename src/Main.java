import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main
{
        public static void main(String[] args) throws IOException
        {
                TeXFormula formula = new TeXFormula("x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}");
                TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 200);
                icon.setInsets(new Insets(5, 5, 5, 5));
                BufferedImage image = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = image.createGraphics();
                g2.setColor(Color.white);
                g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
                JLabel jl = new JLabel();
                jl.setForeground(new Color(0, 0, 0));
                icon.paintIcon(jl, g2, 0, 0);

                File outputfile = new File("image.png");
                ImageIO.write(image, "png", outputfile);
        }
}