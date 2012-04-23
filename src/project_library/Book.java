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
    private boolean isSet;
    private boolean restrictions;
    private boolean fiction;
    private boolean nonFiction;
    private String title;
    private String author;
    private String condition;
    private String status;
    private String category;
    private String description;
    private String checkOutDate;
    private String summary;
    private double price;
    private int checkedOutBy;
    private static int bookID;
   
    Book()
    {
        isSet = false;
        restrictions = false;
        fiction = true;
        nonFiction = true;
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
        return summary;
    }
    
    public void setSummary(String newSummary)
    {
        summary = newSummary;
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
        status = newValue;
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
        checkOutDate = newValue;
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
}
