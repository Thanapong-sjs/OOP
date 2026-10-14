public class DigitException extends Exception {
    public DigitException() { 
        super("(digit is not allowed in name) can not display."); 
    }
    
    @Override 
    public String toString() { 
        return "DigitException : " + getMessage(); 
    }
}