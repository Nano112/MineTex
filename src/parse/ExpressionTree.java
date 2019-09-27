import Exceptions.BadFormatting;
import Exceptions.IncorrectBracketException;
import tiles.TileType;
import tiles.Tiles;

import java.util.ArrayList;

public class ExpressionTree {


    ArrayList<ExpressionTree> childsLeft = new ArrayList();
    ArrayList<ExpressionTree> childsRight = new ArrayList();
    String[] currentExpression;
    boolean root = false;
    boolean hasMathObject;

    MathObject mObject;
    int offset;
    public ExpressionTree(String curent_)
    {
        this.currentExpression = curent_.split("");
        this.root = true;
        this.hasMathObject = false;
        this.offset = 0;
    }

    public ExpressionTree(String[] current_, int offset_, boolean bool)
    {
        this.currentExpression = current_;
        this.offset = offset_;
        this.hasMathObject = bool;
    }

    public void parse() throws BadFormatting, IncorrectBracketException {
        //Step 1: search for binary operand : "+", "=" , ",", "=>", etc... outside of '{ }'
        //Step 2: search for "/" caracter and identify if it is an operand or a letter.

        int binaryOperandIndex = 0;
        int i= 0;
        while(i < this.currentExpression.length)
        {
            if(this.currentExpression[i] == "{") //We do not take into account the binary operands inside brackets -> they will be handled afterwards.
            {
                i = findNextBracket(i);
            }
            //Step 1
            if(Tiles.isBinaryOperand(this.currentExpression[i]))
            {
                this.mObject = new MathObject(this.currentExpression[i], TileType.BOperand);
                this.hasMathObject = true;
                if(i==0 || i+1 == this.currentExpression.length)
                {
                    throw new BadFormatting();
                }else{
                    binaryOperandIndex = i;
                    childsLeft.add(new ExpressionTree(subString(this.currentExpression, 0, binaryOperandIndex), 0, false));
                    childsRight.add(new ExpressionTree(subString(this.currentExpression, binaryOperandIndex+1, this.currentExpression.length), binaryOperandIndex, false));
                    childsLeft.get(0).parse();
                    childsRight.get(0).parse();
                    return;
                }
            }

            if(this.currentExpression[i] == "\\")
            {
                String biggreekletter = Tiles.lookForBigGreekLetter(this.currentExpression, i+1);
                String smallgreekletter = Tiles.lookForBigGreekLetter(this.currentExpression, i+1);
                if(biggreekletter != null)
                {
                    MathObject mob = new MathObject(biggreekletter, TileType.BigGreekLetter);
                    i += biggreekletter.length()+1;

                }
                else if(smallgreekletter != null)
                {
                    MathObject mob = new MathObject(smallgreekletter, TileType.BigGreekLetter);
                    i += smallgreekletter.length()+1;
                }

            }





            i++;
        }




    }

    public void Display()
    {

        for(ExpressionTree et : childsLeft)
        {
            et.Display();
        }
        if(this.hasMathObject) {
            System.out.print("id=\"" + this.mObject.getExpression() + "\",");
        }else{
            String str = "";
            for(int i = 0; i<this.currentExpression.length; i++)
            {
                str += this.currentExpression[i];
            }
            System.out.print("str=\""+str+"\",");
        }
        for(ExpressionTree et : childsRight)
        {
            et.Display();
        }
    }
    private String[] subString(String[] str, int start, int end)
    {
        String[] subString = new String[end-start];
        for(int i = start; i<end; i++)
        {
            subString[i-start] = str[i];
        }

        return subString;
    }


    public int findNextBracket(int Start) throws IncorrectBracketException {
        int i = Start+1;
        int c = 1;
        while(c!=0 && i<this.currentExpression.length)
        {
            String car = this.currentExpression[i];
            if (car.equals("{"))
            {
                c += 1;
            }
            if (car.equals("}"))
            {
                c-= 1;
            }

            i++;
        }

        if(i == this.currentExpression.length)
        {
            throw new IncorrectBracketException(this.offset+Start);
        }else{
            return i;
        }
    }

    public void AddChildLeft(ExpressionTree et)
    {
        childsLeft.add(et);
    }

    public int getChildsNumLeft()
    {
        return this.childsLeft.size()+this.childsRight.size();
    }

    public ArrayList<ExpressionTree> getChildsLeft()
    {
        return this.childsLeft;
    }
}
