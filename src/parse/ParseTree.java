package parse;

public class ParseTree {

    String expression;

    public ParseTree(String expression_)
    {
        this.expression = expression_;
    }

    public void parse()
    {
        ExpressionTree parsed = new ExpressionTree(this.expression);

    }

}
