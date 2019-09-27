package tiles;

import Exceptions.UnknownTile;
import structures.Tuple2;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static tiles.TileType.*;

public class Tiles {

    //WIP
  //  public static Map<String, List<Tuple2>> tilePositions = new ObjectMapper().rea
    public static String[] tilesNumbers = new String[]
            {
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
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

    public static String[] tilesSmallGreekLetters = new String[]
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

    public static String[] tilesBigGreekLetters = new String[]
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

    public static String[] tilesBinaryOperands = new String[]
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

    public static String[] tilesOperands = new String[]
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

}


