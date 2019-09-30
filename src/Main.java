import Exceptions.*;
import parse.ExpressionTree;
import tiles.Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main
{
        public static void main(String[] args) throws IOException, IncorrectBracketException, BadFormatting, BadBracketsFormatException, UnknownTile, UnknownCharacter {

                Tiles tiles = new Tiles();
                /*
                ExpressionTree test = new ExpressionTree("a+b+\\frac{1}{2}=\\sum{k=1}{n}{2k-1}+j");
                test.parse();
                test.Display(0);
                //*/
                ImageIO.write(tiles.getTile("1",1),"png",new File("testOut.png"));
        }
}

