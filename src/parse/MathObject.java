package parse;

import tiles.TileType;

public class MathObject {


    public static MathObject concat = new MathObject("", TileType.Concat);

    String expression;
    TileType tt;
    public MathObject(String expr, TileType tt_)
    {
        this.expression = expr;
        this.tt = tt_;
    }


    public String getExpression()
    {
        return this.expression;
    }



}
