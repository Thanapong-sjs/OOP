public class IncompleteException extends Exception {
    public IncompleteException() { 
        super("(grade I is incomplete) can not display."); 
    }
    
    @Override 
    public String toString() { 
        return "IncompleteException : " + getMessage(); 
    }
}