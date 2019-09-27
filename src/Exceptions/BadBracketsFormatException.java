package Exceptions;

public class BadBracketsFormatException extends Exception {

    int BracketUnfound;
    public BadBracketsFormatException (int buf)
    {
        this.BracketUnfound = buf;
    }

    public String tostring()
    {
        return "Error parsing expression, brackets missing at index "+this.BracketUnfound;
    }
}
