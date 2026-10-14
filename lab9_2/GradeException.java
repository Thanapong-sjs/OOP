public class GradeException extends Exception {
    public GradeException() { 
        super("(grade must be A B C D E F) can not display."); 
    }
    
    @Override 
    public String toString() { 
        return "GradeException : " + getMessage(); 
    }
}