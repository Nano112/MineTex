package parse;

import Exceptions.BadBracketsFormatException;
import Exceptions.BadFormatting;
import Exceptions.IncorrectBracketException;
import tiles.TileOperand;
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

    public ExpressionTree(String[] current_, int offset_, MathObject mob)
    {
        this.currentExpression = current_;
        this.offset = offset_;
        this.hasMathObject = true;
        this.mObject = mob;
    }
    public ExpressionTree(String[] current_, int offset_)
    {
        this.currentExpression = current_;
        this.offset = offset_;
        this.hasMathObject = false;
    }

    public ExpressionTree(MathObject mob, int offset)
    {
        this.offset = offset;
        this.hasMathObject = true;
        this.mObject = mob;
        this.currentExpression = new String[] {""};
    }

    public void setChildsLeft(ArrayList<ExpressionTree> childsLeft) {
        this.childsLeft = childsLeft;
    }

    public void setChildsRight(ArrayList<ExpressionTree> childsRight) {
        this.childsRight = childsRight;
    }

    public ArrayList<ExpressionTree> getChildsRight() {
        return childsRight;
    }

    public ArrayList<ExpressionTree> getChildsLeft() {
        return childsLeft;
    }

    public void parse() throws BadFormatting, IncorrectBracketException, BadBracketsFormatException {
        //Step 1: search for binary operand : "+", "=" , ",", "=>", etc... outside of '{ }'
        //Step 2: Parentheses, Brackets..
        //Step 3: search for "/" character and identify if it is an operand or a special letter.

        int binaryOperandIndex = 0;
        int i= 0;
        //Step 1
        while(i < this.currentExpression.length) {
            if (this.currentExpression[i].equals("{")) //We do not take into account the binary operands inside brackets -> they will be handled afterwards.
            {

                i = findNextBracket(i)-1;
            }
            if (Tiles.isBinaryOperand(this.currentExpression[i])) {
                this.mObject = new MathObject(this.currentExpression[i], TileType.BOperand);
                this.hasMathObject = true;

                if (i == 0 || i + 1 == this.currentExpression.length) {
                    throw new BadFormatting();
                } else {
                    binaryOperandIndex = i;

                    childsLeft.add(new ExpressionTree(subString(this.currentExpression, 0, binaryOperandIndex), this.offset));
                    childsRight.add(new ExpressionTree(subString(this.currentExpression, binaryOperandIndex + 1, this.currentExpression.length), this.offset + binaryOperandIndex));
                    childsLeft.get(0).parse();
                    childsRight.get(0).parse();
                    return;
                }
            }
            i++;
        }
        i = 0;


        while(i < this.currentExpression.length)//Step 3
        {
            if(this.currentExpression[i].equals("\\"))
            {

                String biggreekletter = Tiles.lookForBigGreekLetter(this.currentExpression, i);
                String smallgreekletter = Tiles.lookForBigGreekLetter(this.currentExpression, i);
                String tileoperandletter = Tiles.loofFortilesOperands(this.currentExpression,i);

                if(biggreekletter != null)
                {
                    MathObject mob = new MathObject(biggreekletter, TileType.BigGreekLetter);
                    i += biggreekletter.length();
                }
                else if(smallgreekletter != null)
                {
                    MathObject mob = new MathObject(smallgreekletter, TileType.BigGreekLetter);
                    i += smallgreekletter.length();
                }
                //operand case
                else if(tileoperandletter != null) //uh oh! We need to look for the brackets after the operand!
                {

                    int bracketsneeded = TileOperand.getBracketsNeeded(tileoperandletter); //the number of brackets we need
                    int index = i + tileoperandletter.length()-1; //We are going to browse the rest of the expression in order to find the brackets
                    int ind = i; //for the Error message
                    MathObject mob = new MathObject(tileoperandletter, TileType.Operand);
                    ArrayList<ExpressionTree> bracketsExpression = new ArrayList<>();
                    while(index < this.currentExpression.length)
                    {

                        //cas ou l'on a "^{machin..}" ou "_{machin...}"
                        if(index < this.currentExpression.length-2 && (this.currentExpression[index].equals("_") || this.currentExpression[index].equals("^")) && this.currentExpression[index+1].equals("{"))
                        {
                            int nextbracketindex = findNextBracket(index+1)-1;
                            MathObject mobj = new MathObject(this.currentExpression[i]+"{}", TileType.Brackets);
                            bracketsExpression.add(new ExpressionTree(subString(this.currentExpression, index+1, nextbracketindex), this.offset+index, mobj));
                            bracketsneeded--;
                            index = nextbracketindex;
                        }
                        //cas ou l'on a seulement "{machin....}"
                        if(this.currentExpression[index].equals("{"))
                        {
                            int nextbracketindex = findNextBracket(index)-1;

                            MathObject mobj = new MathObject("{}", TileType.Brackets);
                            ExpressionTree exp = new ExpressionTree(mobj, this.offset+index);
                            exp.childsRight.add(new ExpressionTree(subString(this.currentExpression, index+1, nextbracketindex), this.offset));
                            bracketsExpression.add(exp);
                            bracketsneeded--;
                            index = nextbracketindex;
                        }
                        if(bracketsneeded == 0)
                        {    //If we have nothing left, we can just put the oject inside the treeExpression, otherwise we need to create a branch we a concat operator
                            ExpressionTree opexp = new ExpressionTree(mob, this.offset+i);
                            opexp.childsRight = bracketsExpression;
                            if(index == this.currentExpression.length-1)
                            {
                                if(!this.hasMathObject)
                                {
                                    this.mObject = mob;
                                    this.hasMathObject = true;
                                    this.childsRight= bracketsExpression;
                                }else{

                                    this.childsRight.add(opexp);
                                }
                            }else{
                                String[] reste = subString(this.currentExpression, index+1, this.currentExpression.length);
                                ExpressionTree resteexp = new ExpressionTree(reste, this.offset+index+1);
                                MathObject concat = MathObject.concat;
                                ExpressionTree et = new ExpressionTree(concat, this.offset+index);
                                et.childsRight.add(opexp);
                                et.childsLeft.add(resteexp);
                                if(this.hasMathObject)
                                {
                                    this.childsLeft.add(et);
                                }else{
                                    this.mObject = concat;
                                    this.hasMathObject = true;
                                    this.childsLeft.add(opexp);
                                    this.childsRight.add(resteexp);
                                }
                            }
                            for(ExpressionTree et : this.childsRight)
                            {
                                et.parse();
                            }
                            for(ExpressionTree et : this.childsLeft)
                            {
                                et.parse();
                            }
                            i = index;
                            return;
                        }
                        index++;
                    }
                    if(bracketsneeded != 0) //not enough brackets found.
                    {
                         throw new BadBracketsFormatException(ind);
                    }
                }
            }

            i++;
        }


    }
    public void printDebug(String[] str)
    {
        String res = "";
        for(int i = 0; i < str.length; i++)
        {
            res+=str[i];
        }
        System.out.println(res);
    }

    public String mult(String str, int depth)
    {
        if(depth == 0) return "";
        String str_  = "";
        for(int i = 0;i<depth; i++)
        {
            str_ += str;
        }
        return str_;
    }
    public void Display(int depth)
    {

        String line = "    ";
        line = mult(line, depth);

        System.out.println(line+"{");
        if(this.hasMathObject)
        {

            System.out.println(line+"    id=\""+this.mObject.expression+"\"");
        }else{
            String res = "";
            for(int i = 0; i < this.currentExpression.length; i++)
            {
                res += this.currentExpression[i];
            }
            System.out.println(line+"    " + "\""+res+"\"");
        }

        if(this.childsRight.size()+this.childsLeft.size() != 0)
        {

            if(this.childsLeft.size() != 0)
            {
                System.out.println(line+"   ChildsLeft=");
            }
            for(ExpressionTree et : this.childsLeft)
            {
                et.Display(depth+1);
            }
            if(this.childsRight.size() != 0)
            {
                System.out.println(line+"    ChildsRight=");
            }
            for(ExpressionTree et : this.childsRight)
            {
                et.Display(depth+1);
            }



        }
        System.out.println(line+"}");
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
        if(c != 0)
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


}
