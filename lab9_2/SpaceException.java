public class SpaceException extends Exception {
    public SpaceException() { 
        super("(space is not allowed in name) can not display."); 
    }
    
    @Override 
    public String toString() { 
        return "SpaceException : " + getMessage(); 
    }
}