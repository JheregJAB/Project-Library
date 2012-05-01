/*
 * Contains settings for Project Library
 */
package project_library;
/**
 *
 * @author jacob
 */
public class Library 
{//begin Library Class
    private boolean isPassSet;
    private String libraryName;
    private String password;
    private double fine;
    private double maxFine;
    private int checkoutTime;
  
    Library()
    {
        isPassSet = false;
        fine = 0.00;
        maxFine = -1;
        password = "";
    }
  
    public String getlibraryName()
    {
        return libraryName;
    }
   
    public String getPassword()
    {
        return password;
    }

    public double getFine()
    {
        return fine;
    }
   
    public double getMaxFine()
    {
        return maxFine;
    }
 
    public int getCheckoutTime()
    {
        return checkoutTime;
    }
 
    public void setlibraryName(String newValue)
    {
        libraryName = newValue;
    }
 
    public void setPassword(String newValue)
    {
        if (newValue == null)
            isPassSet = false;
        else
            isPassSet=true;
        password = newValue;
    }

    public void setFine(double newValue)
    {
        fine = newValue;
    }
   
    public void setMaxFine(double newValue)
    {
        maxFine = newValue;
    }

    public void setCheckoutTime(int newValue)
    {
        checkoutTime = newValue;
    }

    public boolean isPassSet()
    {
        return isPassSet;
    }
}//end Library Class
