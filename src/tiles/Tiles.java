package tiles;

import Exceptions.UnknownCharacter;
import Exceptions.UnknownTile;
import structures.TilePosition;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class Tiles {

    private static BufferedImage tileSet1 = null;
    static
    {
        try {
            File f = new File("./src/ressources/lookup_3x5.bmp");
            tileSet1 = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage tileSet2 = null;
    static
    {
        try {
            File f = new File("./src/ressources/lookup_5x7.bmp");
            tileSet2 = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Map<String, TilePosition>> tileNamePositions;
    static
    {
        tileNamePositions = new HashMap<>();
        HashMap<String, TilePosition> hm;
        //Numbers

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(0,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(0,7,5, 7));
        tileNamePositions.put( "0" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(1,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(1,7,5, 7));
        tileNamePositions.put( "1" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(2,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(2,7,5, 7));
        tileNamePositions.put( "2" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(3,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(3,7,5, 7));
        tileNamePositions.put( "3" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(4,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(4,7,5, 7));
        tileNamePositions.put( "4" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(5,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(5,7,5, 7));
        tileNamePositions.put( "5" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(6,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(6,7,5, 7));
        tileNamePositions.put( "6" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(7,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(7,7,5, 7));
        tileNamePositions.put( "7" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(8,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(8,7,5, 7));
        tileNamePositions.put( "8" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_3x5.bmp",new TilePosition(9,0,3, 5));
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(9,7,5, 7));
        tileNamePositions.put( "9" ,hm);

        //Big Letters
        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(0,0,5, 7));
        tileNamePositions.put( "A" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(1,0,5, 7));
        tileNamePositions.put( "B" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(2,0,5, 7));
        tileNamePositions.put( "C" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(3,0,5, 7));
        tileNamePositions.put( "D" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(4,0,5, 7));
        tileNamePositions.put( "E" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(5,0,5, 7));
        tileNamePositions.put( "F" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(6,0,5, 7));
        tileNamePositions.put( "G" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(7,0,5, 7));
        tileNamePositions.put( "H" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(8,0,5, 7));
        tileNamePositions.put( "I" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(9,0,5, 7));
        tileNamePositions.put( "J" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(10,0,5, 7));
        tileNamePositions.put( "K" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(11,0,5, 7));
        tileNamePositions.put( "L" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(12,0,5, 7));
        tileNamePositions.put( "M" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(13,0,5, 7));
        tileNamePositions.put( "N" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(14,0,5, 7));
        tileNamePositions.put( "O" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(15,0,5, 7));
        tileNamePositions.put( "P" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(16,0,5, 7));
        tileNamePositions.put( "Q" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(17,0,5, 7));
        tileNamePositions.put( "R" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(18,0,5, 7));
        tileNamePositions.put( "S" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(19,0,5, 7));
        tileNamePositions.put( "T" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(20,0,5, 7));
        tileNamePositions.put( "U" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(21,0,5, 7));
        tileNamePositions.put( "V" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(22,0,5, 7));
        tileNamePositions.put( "W" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(23,0,5, 7));
        tileNamePositions.put( "X" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(24,0,5, 7));
        tileNamePositions.put( "Y" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp",new TilePosition(25,0,5, 7));
        tileNamePositions.put( "Z" ,hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(0, 1,5, 7));
        tileNamePositions.put("a", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(1, 1,5, 7));
        tileNamePositions.put("b", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(2, 1,5, 7));
        tileNamePositions.put("c", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(3, 1,5, 7));
        tileNamePositions.put("d", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(4, 1,5, 7));
        tileNamePositions.put("e", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(5, 1,5, 7));
        tileNamePositions.put("f", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(6, 1,5, 7));
        tileNamePositions.put("g", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(7, 1,5, 7));
        tileNamePositions.put("h", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(8, 1,5, 7));
        tileNamePositions.put("i", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(9, 1,5, 7));
        tileNamePositions.put("j", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(10, 1,5, 7));
        tileNamePositions.put("k", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(11, 1,5, 7));
        tileNamePositions.put("l", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(12, 1,5, 7));
        tileNamePositions.put("m", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(13, 1,5, 7));
        tileNamePositions.put("n", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(14, 1,5, 7));
        tileNamePositions.put("o", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(15, 1,5, 7));
        tileNamePositions.put("p", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(16, 1,5, 7));
        tileNamePositions.put("q", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(17, 1,5, 7));
        tileNamePositions.put("r", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(18, 1,5, 7));
        tileNamePositions.put("s", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(19, 1,5, 7));
        tileNamePositions.put("t", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(20, 1,5, 7));
        tileNamePositions.put("u", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(21, 1,5, 7));
        tileNamePositions.put("v", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(22, 1,5, 7));
        tileNamePositions.put("w", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(23, 1,5, 7));
        tileNamePositions.put("x", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(24, 1,5, 7));
        tileNamePositions.put("y", hm);

        hm = new HashMap<>();
        hm.put("ressources/lookup_5x7.bmp", new TilePosition(25, 1,5, 7));
        tileNamePositions.put("z", hm);

    }


    public static String[] tilesNumbers = new String[]
            {
                    "1",
                    "1",
                    "2",
                    "3",
                    "5",
                    "6",
                    "6",
                    "7",
                    "9"
            };

    public static String[] tilesSmallLetters = new String[]
            {
                    "a",
                    "b",
                    "c",
                    "d",
                    "e",
                    "f",
                    "g",
                    "h",
                    "i",
                    "j",
                    "k",
                    "l",
                    "m",
                    "n",
                    "o",
                    "p",
                    "q",
                    "r",
                    "s",
                    "t",
                    "u",
                    "v",
                    "w",
                    "w",
                    "x",
                    "y",
                    "z"
            };

    public static String[] tilesBigLetters = new String[]
            {
                    "A",
                    "B",
                    "C",
                    "D",
                    "E",
                    "F",
                    "G",
                    "H",
                    "I",
                    "J",
                    "K",
                    "L",
                    "M",
                    "N",
                    "O",
                    "P",
                    "Q",
                    "R",
                    "S",
                    "T",
                    "U",
                    "V",
                    "W",
                    "X",
                    "Y",
                    "Z"
            };

    private static String[] tilesSmallGreekLetters = new String[]
            {
                    "\\alpha",
                    "\\beta",
                    "\\gamma",
                    "\\delta",
                    "\\epsilon",
                    "\\zeta",
                    "\\eta",
                    "\\theta",
                    "\\iota",
                    "\\kappa",
                    "\\lambda",
                    "\\mu",
                    "\\nu",
                    "\\xi",
                    "\\omicron",
                    "\\pi",
                    "\\rho",
                    "\\sigma",
                    "\\tau",
                    "\\upsilon",
                    "\\phi",
                    "\\chi",
                    "\\psi",
                    "\\omega"
            };

    private static String[] tilesBigGreekLetters = new String[]
            {
                    "\\Alpha",
                    "\\Beta",
                    "\\Gamma",
                    "\\Delta",
                    "\\Epsilon",
                    "\\Zeta",
                    "\\Eta",
                    "\\Theta",
                    "\\Iota",
                    "\\Kappa",
                    "\\Lambda",
                    "\\Mu",
                    "\\Nu",
                    "\\Xi",
                    "\\Omicron",
                    "\\Pi",
                    "\\Rho",
                    "\\Sigma",
                    "\\Tau",
                    "\\Upsilon",
                    "\\Phi",
                    "\\Chi",
                    "\\Psi",
                    "\\Omega",
            };


    public static String[] tilesMisc = new String[]
            {
                    "\\partial",



            };

    public static String[] tilesSpecial = new String[]
            {
                    "{",
                    "}",
                    "[",
                    "]",
                    "(",
                    ")",
            };

    private static String[] tilesBinaryOperands = new String[]
            {
                    "+",
                    ",",
                    "-",
                    "=",
                    "*",
                    "<",
                    ">",
                    "^",
            };

    private static String[] tilesOperands = new String[]
            {
                    "\\times",
                    "\\frac",
                    "\\lim",
                    "\\int",
                    "\\bar",
                    "\\abs",
                    "\\sqrt",
                    "\\sum",
                    "\\prod"
            };


    public static boolean isGreekLetter(String str)
    {
        for(String op : tilesBigGreekLetters)
        {
            if(op.equals(str))
            {
                return true;
            }
        }

        for(String op : tilesSmallGreekLetters)
        {
            if(op.equals(str))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperand(String str)
    {
        for(String op : tilesOperands)
        {
            if(op.equals(str))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isBinaryOperand(String str)
    {
        for(String op : tilesBinaryOperands)
        {
            if(op.equals(str))
            {
                return true;
            }
        }
        return false;
    }

    public static String lookForBigGreekLetter(String[] str, int index)
    {
        boolean flag;
        for (String op : tilesBigGreekLetters)
        {
            String[] opa = op.split("");
            flag = true;
            for (int i = 0; i < op.length(); i++)
            {
                if(!opa[i].equals(str[i+index]))
                {
                    flag = false;
                }
            }

            if (flag) return op;
        }
        return null;
    }

    public static String lookForSmallGreekLetter(String[] str, int index)
    {
        boolean flag;
        for(String op : tilesSmallGreekLetters)
        {
            String[] opa = op.split("");
            flag = true;
            for(int i = 0; i<op.length(); i++)
            {
                if(!opa[i].equals(str[i+index]))
                {
                    flag = false;
                }
            }

            if(flag) return op;

        }
        return null;
    }

    public static String loofFortilesOperands(String[] str, int index)
    {
        boolean flag;
        for(String op : tilesOperands)
        {
            String[] opa = op.split("");
            flag = true;
            for(int i = 0; i<op.length(); i++)
            {

                if(!opa[i].equals(str[i+index]))
                {
                    flag = false;
                }
            }

            if(flag) return op;

        }
        return null;
    }

    public static BufferedImage getTile(String string, int size) throws UnknownTile, UnknownCharacter
    {
        String sizeName;
        switch (size)
        {
            case 1:
                sizeName = "ressources/lookup_3x5.bmp";
                break;
            case 2:
                sizeName = "ressources/lookup_5x7.bmp";
                break;
            default:
                throw new UnknownTile();
        }

        Map<String,TilePosition> tilePositions = tileNamePositions.get(string);
        if (tilePositions == null)
        {
            throw new UnknownTile();
        }
        TilePosition tp = tilePositions.get(sizeName);
        if(tp == null)
        {
            throw new UnknownCharacter();
        }

        switch (size)
        {
            case 1:
                return tileSet1.getSubimage(tp.collumn,tp.row, tp.width, tp.height);
            case 2:
                return tileSet2.getSubimage(tp.collumn, tp.row, tp.width, tp.height);
            default:
                throw new UnknownTile();
        }
    }

}


