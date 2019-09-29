import Exceptions.BadBracketsFormatException;
import Exceptions.BadFormatting;
import Exceptions.IncorrectBracketException;
import parse.ExpressionTree;

import java.io.IOException;

public class Main
{
        public static void main(String[] args) throws IOException, IncorrectBracketException, BadFormatting, BadBracketsFormatException {

                ExpressionTree test = new ExpressionTree("a+b+\\frac{1}{2}=\\sum{k=1}{n}{2k-1}+j");
                test.parse();
                test.Display(0);
        }
}

