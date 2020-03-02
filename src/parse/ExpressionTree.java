package parse;

import Exceptions.BadBracketsFormatException;
import Exceptions.BadFormatting;
import Exceptions.IncorrectBracketException;
import tiles.TileOperand;
import tiles.TileType;
import tiles.Tiles;

import java.beans.Expression;
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
        //Step 4: check for numbers and letters only.
        int binaryOperandIndex = 0;
        int i= 0;
        //Step 1
        while(i < this.currentExpression.length) {
            for(int j = 0; j<3; j++) {
                if (this.currentExpression[i].equals(Tiles.tilesSpecial[2*j])) //We do not take into account the binary operands inside brackets -> they will be handled afterwards.
                {
                    i = findNext(Tiles.tilesSpecial[2*j],Tiles.tilesSpecial[2*j+1],i) - 1;
                }
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
        while(i < this.currentExpression.length)//Step 2
        {

            if (this.currentExpression[i].equals("{")) //We do not take into account the content inside brackets -> they will be handled afterwards.
            {
                i = findNextBracket(i)-1;
            }

            if(this.currentExpression[i].equals("\\"))
            {
                //Search for a token
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
                    int ind = i;
                    MathObject mob = new MathObject(tileoperandletter, TileType.Operand);
                    ArrayList<ExpressionTree> bracketsExpression = new ArrayList<>();
                    while(index < this.currentExpression.length)
                    {   //cas ou l'on a "^{machin..}" ou "_{machin...}"
                        if(index < this.currentExpression.length-2 && (this.currentExpression[index].equals("_") || this.currentExpression[index].equals("^")) && this.currentExpression[index+1].equals("{"))
                        {
                            int nextbracketindex = findNextBracket(index+1)-1;
                            MathObject mobj = new MathObject(this.currentExpression[i]+"{}", TileType.Brackets);
                            ExpressionTree exp = new ExpressionTree(mobj, this.offset+index);
                            ExpressionTree newchild = new ExpressionTree(subString(this.currentExpression, index+1, nextbracketindex), this.offset);
                            newchild.parse();
                            exp.childsRight.add(newchild);
                            bracketsExpression.add(exp);
                            bracketsneeded--;
                            index = nextbracketindex;
                        }
                        //cas ou l'on a seulement "{machin....}"
                        if(this.currentExpression[index].equals("{"))
                        {
                            int nextbracketindex = findNextBracket(index)-1;
                            MathObject mobj = new MathObject("{}", TileType.Brackets);
                            ExpressionTree exp = new ExpressionTree(mobj, this.offset+index);
                            ExpressionTree newchild = new ExpressionTree(subString(this.currentExpression, index+1, nextbracketindex), this.offset);
                            newchild.parse();
                            exp.childsRight.add(newchild);
                            bracketsExpression.add(exp);
                            bracketsneeded--;
                            index = nextbracketindex;
                        }
                        if(bracketsneeded == 0)
                        {   //If we have nothing left, we can just put the oject inside the treeExpression, otherwise we need to create a branch we a concat operator
                            ExpressionTree opexp = new ExpressionTree(mob, this.offset+i);
                            this.hasMathObject = true;
                            opexp.childsRight = bracketsExpression;
                            String[] reste_gauche = subString(this.currentExpression, 0, ind);
                            String[] reste_droite = subString(this.currentExpression, index+1, this.currentExpression.length);
                            if(reste_droite.length == 0 && reste_gauche.length == 0)
                            {
                                this.mObject = mob;
                                this.childsRight= bracketsExpression;
                            }else if(reste_gauche.length == 0 && reste_droite.length != 0){

                                ExpressionTree resteexp = new ExpressionTree(reste_droite, this.offset+index+1);
                                resteexp.parse();
                                this.mObject = MathObject.concat;
                                this.childsLeft.add(opexp);
                                this.childsRight.add(resteexp);
                            }else if(reste_gauche.length != 0 && reste_droite.length == 0){
                                ExpressionTree resteexp = new ExpressionTree(reste_gauche, this.offset+index+1);
                                resteexp.parse();
                                this.mObject = MathObject.concat;
                                this.childsRight.add(opexp);
                                this.childsLeft.add(resteexp);
                            }else if(reste_gauche.length != 0 && reste_droite.length != 0) {
                                ExpressionTree dr = new ExpressionTree(reste_droite, this.offset + index + 1);
                                ExpressionTree le = new ExpressionTree(reste_gauche, this.offset + index + 1);
                                le.parse();
                                dr.parse();
                                this.mObject = MathObject.concat;
                                ExpressionTree obleft = new ExpressionTree(MathObject.concat, this.offset + index + 1);
                                obleft.childsLeft.add(le);
                                obleft.childsRight.add(opexp);
                                this.childsRight.add(dr);
                                this.childsLeft.add(obleft);

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
        i = 0;
        while(i < this.currentExpression.length)
        {
            if (this.currentExpression[i].equals("{")) //We do not take into account the content inside brackets -> they will be handled afterwards.
            {
                i = findNextBracket(i)-1;
            }
            for(int x = 0; x<3; x++)
            {
                if(this.currentExpression[i].equals(Tiles.tilesSpecial[2*x])) {

                    int index = findNext(Tiles.tilesSpecial[2*x], Tiles.tilesSpecial[2*x+1], i);
                    this.mObject = MathObject.concat;
                    this.hasMathObject = true;
                    String[] reste_gauche = subString(this.currentExpression, 0, i);
                    String[] reste_droite = subString(this.currentExpression, index , this.currentExpression.length);
                    String[] par = subString(this.currentExpression, i + 1, index-1);
                    ExpressionTree exp = new ExpressionTree(par, this.offset + i);



                    ExpressionTree ex = new ExpressionTree(new MathObject(Tiles.tilesSpecial[2*x]+Tiles.tilesSpecial[2*x+1], TileType.Special), this.offset+i);
                    exp.parse();
                    ex.childsLeft.add(exp);
                    if (reste_droite.length == 0 && reste_gauche.length == 0) {
                        this.childsLeft.add(ex);
                    }
                    if (reste_droite.length != 0 && reste_gauche.length == 0) {
                        ExpressionTree par1 = new ExpressionTree(reste_droite, 0);
                        par1.parse();
                        this.childsLeft.add(ex);
                        this.childsRight.add(par1);
                    }
                    if (reste_droite.length == 0 && reste_gauche.length != 0) {
                        ExpressionTree par2 = new ExpressionTree(reste_gauche, this.offset + index);
                        par2.parse();
                        this.childsRight.add(ex);
                        this.childsLeft.add(par2);
                    }
                    if (reste_droite.length != 0 && reste_gauche.length != 0) {
                        ExpressionTree par1 = new ExpressionTree(reste_droite, 0);
                        ExpressionTree par2 = new ExpressionTree(reste_gauche, this.offset + index);
                        par1.parse();
                        par2.parse();
                        this.childsLeft.add(par2);
                        this.childsLeft.add(ex);
                        this.childsRight.add(par1);
                    }
                    return;
                }


            }
            i++;


        }

        String tr = "";
        for(String str : this.currentExpression)
        {
            tr += str;
        }
        System.out.println(tr);
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
            System.out.println(line+"    id=\""+this.mObject.expression+"\""+ ",type="+this.mObject.tt);
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
                System.out.println(line+"    ChildsLeft=");
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

    public int findNext(String str1, String str2, int Start) throws IncorrectBracketException {
        int i = Start+1;
        int c = 1;
        while(c!=0 && i<this.currentExpression.length)
        {
            String car = this.currentExpression[i];


            if (car.equals(str1))
            {
                c += 1;
            }
            if (car.equals(str2))
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
