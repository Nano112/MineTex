package tiles;

public class Tiles {

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

    public static String[] tilesLetters = new String[]
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
                    "z",
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

    public static String[] tilesGreekLetters = new String[]
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
                    "\\omega",
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
            };


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
}


