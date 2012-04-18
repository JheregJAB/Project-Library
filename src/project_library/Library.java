/*
 * Will eventually contain settings for the Library for Project Library
 */
package project_library;
/**
 *
 * @author jacob
 */
public class Library 
{//begin Library Class
    //temporary members
    String string;
    
    //temporary constructor
    Library()
    {
        string = "This is the library settings";
    }
    
    public String getString()
    {
        return string;
    }
    
    public void setString(String string)
    {
        this.string=string;
    }
}//end Library Class
