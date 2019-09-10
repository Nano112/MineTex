package Exceptions;

public class IncorrectBracketException extends Exception{
    int BracketUnfound;
    public IncorrectBracketException(int buf)
    {
        this.BracketUnfound = buf;
    }

    public String tostring()
    {
        return "Error parsing expression, bracket at position "+this.BracketUnfound+" is not closed";
    }
}
