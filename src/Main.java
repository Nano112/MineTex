import Exceptions.BadBracketsFormatException;
import Exceptions.BadFormatting;
import Exceptions.IncorrectBracketException;
import parse.ExpressionTree;

import java.io.IOException;

public class Main
{
        public static void main(String[] args) throws IOException, IncorrectBracketException, BadFormatting, BadBracketsFormatException {

              //  ExpressionTree test = new ExpressionTree("a+b+\\frac{1}{2}=\\sum{k=1}{n}{2k-1}");
                ExpressionTree test2 = new ExpressionTree("\\frac{\\delta}{2}");
                test2.parse();
                //test.parse();

                test2.Display(0);


                //test.Display(0);
        }
}

