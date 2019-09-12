package Exceptions;

public class UnknowStringException extends Exception{

    public UnknowStringException()
    {

    }

    public String tostring()
    {
        return "Error, character sequence not valid";
    }
}
