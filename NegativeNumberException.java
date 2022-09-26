public class NegativeNumberException extends Exception{
    public NegativeNumberException(){}

    public NegativeNumberException(String errorMessage){
        super(errorMessage);
    }

    public NegativeNumberException(Throwable cause){
        super(cause);
    }
}
