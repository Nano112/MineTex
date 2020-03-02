import Exceptions.*;
import graphics.FormulaImage;
import parse.ExpressionTree;
import structures.TileImage;
import tiles.Tiles;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
        public static void main(String[] args) throws IOException, IncorrectBracketException, BadFormatting, BadBracketsFormatException, UnknownTile, UnknownCharacter {

                Tiles tiles = new Tiles();
                String input = "a+b+a(a+b)\\frac{1}{2}=\\sum{k=1}{n}{(2k-1)}+j";
                ExpressionTree test = new ExpressionTree(input);
                System.out.println("input="+input);
                test.parse();
                test.Display(0);
                //*/
                ArrayList<TileImage> tileImages = new ArrayList<>();
                FormulaImage formulaImage = new FormulaImage(5*3+4,5);
                tileImages.add(new TileImage(0,0,tiles.getTile("4",1)));
                tileImages.add(new TileImage(4,0,tiles.getTile("2",1)));
                tileImages.add(new TileImage(8,0,tiles.getTile("0",1)));
                tileImages.add(new TileImage(12,0,tiles.getTile("6",1)));
                tileImages.add(new TileImage(16,0,tiles.getTile("9",1)));
                formulaImage.addTiles(tileImages);
                ImageIO.write(formulaImage.image,"png",new File("testOut.png"));
        }
}
