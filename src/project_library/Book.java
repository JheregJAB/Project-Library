/*
 * Will eventually contain data associated with a single book for
 * project library
 */
package project_library;

/**
 *
 * @author jacob
 */
public class Book 
{
    private String string;
    
    Book()
    {
        string = "This is a book!";
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
