/*
 * Will eventually contain data associated with a single book for
 * project library
 */
package project_library;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author jacob
 */
public class Book 
{
    private boolean isSet;
    private boolean restrictions;
    private boolean fiction;
    private String title;
    private String author;
    private String condition;
    private String status;
    private String category;
    private String description;
    private Date checkOutDate;
    //private String summary;
    private double price;
    private int checkedOutBy;
    private static int bookID;
   
    Book()
    {
        isSet = false;
        restrictions = false;
        fiction = true;
    }
   
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthor()
    {
        return author;
    }
  
    public String getCondition()
    {
        return condition;
    }
  
    public String getStatus()
    {
        return status;
    }
  
    public String getCategory()
    {
        return category;
    }
  
    public String getDescription()
    {
        return description;
    }
   
    public String getCheckOutDate()
    {
        return String.valueOf(checkOutDate.getMonth()+1)+"/"+String.valueOf(checkOutDate.getDate())+"/"+String.valueOf(checkOutDate.getYear());
    }
    
    public Date getCheckoutDateRaw()
    {
        return checkOutDate;
    }

    public double getPrice()
    {
        return price;
    }
 
    public int getCheckedOutBy()
    {
        return checkedOutBy;
    }
  
    public static int getBookID()
    {
        return bookID;
    }
    
    public String getSummary()
    {
        return description;
    }
    
    public void setSummary(String newSummary)
    {
        description = newSummary;
    }
  
    public void setTitle(String newValue)
    {
        title = newValue;
    }
  
    public void setCondition(String newValue)
    {
        condition = newValue;
    }
  
    public void setStatus(String newValue)
    {
        if (checkedOutBy != -1)
            status = "Checked Out";
        else
            status = "Available";
    }
  
    public void setCategory(String newValue)
    {
        category = newValue;
    }
  
    public void setDescription(String newValue)
    {
        description = newValue;
    }
  
    public void setCheckOutDate(String newValue)
    {
        String[] splitString = newValue.split("/");

        if (splitString.length != 3)
            checkOutDate = new GregorianCalendar(0,0,0).getTime();
        else
        {
            int month = Integer.parseInt(splitString[0]) - 1;
            int date = Integer.parseInt(splitString[1]);
            int year = Integer.parseInt(splitString[2]);
            checkOutDate = new GregorianCalendar(year,month,date).getTime();
        }
    }
    
    public void setCheckoutDateRaw(Date newDate)
    {
        checkOutDate = newDate;
    }

    public void setPrice(double newValue)
    {
        price = newValue;
    }

    public void setCheckedOutBy(int newValue)
    {
        checkedOutBy = newValue;
    }
   
    public void setBookID(int newValue)
    {
        bookID = newValue;
    }
    
    public void setAuthor(String newAuthor)
    {
        author = newAuthor;
    }
   
    public boolean isSet()
    {
        return isSet;
    }
   
    public void setIsSet()
    {
        isSet = true;
    }
    
    public boolean Restricted()
    {
        return restrictions;
    }
    
    public boolean Fiction()
    {
        return fiction;
    }
    
    public void setFiction(boolean newValue)
    {
        fiction = newValue;
    }
    
    public void setRestricted(boolean isRestricted)
    {
        restrictions = isRestricted;
    }
    
    public String getType()
    {
        if (fiction)
            return "Fiction";
        else
            return "Non-Fiction";
    }
    
    public void setCheckOutDateRaw(Date newdate)
    {
        checkOutDate = newdate;
    }
}
