/*
 * Will eventually contain data associated with a single Patron for
 * project library
 */
package project_library;

/**
 *
 * @author jacob
 */
public class Patron 
{
    private String string;
    
    Patron()
    {
        string = "This is a Patron!";
    }

    public String getString() 
    {
        return string;
    }

    public void setString(String string) 
    {
        this.string = string;
    }

}
