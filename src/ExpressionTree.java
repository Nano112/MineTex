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


    MathObject mObject;
    int offset;
    public ExpressionTree(String curent_)
    {
        this.currentExpression = curent_.split("");
        this.root = true;
        this.offset = 0;
    }

    public ExpressionTree(String[] current_, int offset_)
    {
        this.currentExpression = current_;
        this.offset = offset_;
    }

    public void parse() throws BadFormatting, IncorrectBracketException {
        //Step 1: search for binary operand : "+", "=" , ",", "=>", etc... outside of '{ }'


        int binaryOperandIndex = 0;
        int i= 0;
        while(i < this.currentExpression.length)
        {
            if(this.currentExpression[i] == "{") //We do not take into account the binary operands inside brackets -> they will be handled afterwards.
            {
                i = findNextBracket(i);
            }

            if(Tiles.isBinaryOperand(this.currentExpression[i]))
            {
                this.mObject = new MathObject(this.currentExpression[i], TileType.BOperand);
                if(i==0 || i+1 == this.currentExpression.length)
                {
                    System.out.println(i);
                    throw new BadFormatting();
                }else{
                    binaryOperandIndex = i;
                    childsLeft.add(new ExpressionTree(subString(this.currentExpression, 0, binaryOperandIndex), 0));

                    childsRight.add(new ExpressionTree(subString(this.currentExpression, binaryOperandIndex+1, this.currentExpression.length), binaryOperandIndex));

                    childsLeft.get(0).parse();
                    childsRight.get(0).parse();
                    return;
                }
            }

            i++;
        }

        if (binaryOperandIndex != 0)
        {

        }else{

        }



    }

    public void Display()
    {

        for(ExpressionTree et : childsLeft)
        {
            et.Display();
        }
        System.out.print("id=\""+this.mObject.getExpression()+"\",");
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
