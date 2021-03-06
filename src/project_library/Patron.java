/*
 * Will eventually contain data associated with a single Patron for
 * project library
 */
package project_library;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *
 * @author jacob
 */
public class Patron 
{
    private boolean isSet;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    //private String restrictedTo;
    private String membershipStatus;
    private Date birthday;
    private double fine;
    private double specialFine;
    private static int patronID;
    private int[] checkedBooks = {-1};
    private double oldFines = 0.0;
    
    Patron()
    {
        isSet = false;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
   
    public String getLastName()
    {
        return lastName;
    }
   
    public String getStreet()
    {
        return street;
    }
   
    public String getCity()
    {
        return city;
    }
   
    public String getState()
    {
        return state;
    }
   
    public String getZipCode()
    {
        return zipCode;
    }
   
    public String getPhone()
    {
        return phone;
    }
   
    public String getEmail()
    {
        return email;
    }
   
    /*public String getRestrictedTo()
    {
        return restrictedTo;
    }*/
   
    public String getMembershipStatus()
    {
        return membershipStatus;
    }
   
    public String getBirthday()
    {
        return String.valueOf(birthday.getMonth())+"/"+String.valueOf(birthday.getDay())+"/"+String.valueOf(birthday.getYear());
    }
    
    public Date getBirthdayRaw()
    {
        return birthday;
    }
   
    public double getFine()
    {
        return fine;
    }
   
    public double getSpecialFine()
    {
        return specialFine;
    }
   
    public int[] getCheckedBooks()
    {
        return checkedBooks;
    }
   
    public static int getPatronID()
    {
        return patronID;
    }
   
    public void setFirstName(String newValue)
    {
        firstName = newValue;
    }
   
    public void setLastName(String newValue)
    {
        lastName = newValue;
    }
   
    public void setStreet(String newValue)
    {
        street = newValue;
    }
   
    public void setCity(String newValue)
    {
        city = newValue;
    }
   
    public void setState(String newValue)
    {
        state = newValue;
    }
   
    public void setZipCode(String newValue)
    {
        zipCode = newValue;
    }
   
    public void setPhone(String newValue)
    {
        phone = newValue;
    }
   
    public void setEmail(String newValue)
    {
        email = newValue;
    }
   
    /*public void setRestrictedTo(String newValue)
    {
        restrictedTo = newValue;
    }*/
   
    public void setBirthday(String newValue)
    {
        String[] splitString = newValue.split("/");

        if (splitString.length != 3)
            birthday = new GregorianCalendar(0,0,0).getTime();
        else
        {
            int month = Integer.parseInt(splitString[0]) - 1;
            int date = Integer.parseInt(splitString[1]);
            int year = Integer.parseInt(splitString[2]);
            birthday = new GregorianCalendar(year,month,date).getTime();
        }
    }
    
    public void setBirthdayRaw(Date newValue)
    {
        birthday = newValue;
    }
   
    public void setFine(double newValue)
    {
        fine = newValue;
    }
   
    public void setSpecialFine(double newValue)
    {
        specialFine = newValue;
    }
   
    public void setCheckedBooks(int[] newValue)
    {
        checkedBooks = newValue;
    }
    
    public void setCheckedBooks(int newValue)
    {
        boolean foundEmptyBook =false;
        for (int i=0; i<checkedBooks.length;i++)
        {
            if (checkedBooks[i] == -1)
            {
                checkedBooks[i]=newValue;
                foundEmptyBook = true;
            }
            if (foundEmptyBook)
                break;
        }
        if (!foundEmptyBook)
        {
            int[] temp = new int[checkedBooks.length+1];
            for (int n=0; n<checkedBooks.length;n++)
            {
                temp[n]=checkedBooks[n];
            }
            temp[temp.length-1]=newValue;    
            checkedBooks = temp;
        }
            
        
    }
   
    public void setPatronID(int newValue)
    {
        patronID = newValue;
    }
    
    public boolean isSet()
    {
        return isSet;
    }
    
    public void setIsSet()
    {
        isSet = true;
    }
    
    public void setMembershipStatus(String status)
    {
        membershipStatus=status;
    }
    
    public double getOldFines()
    {
        return oldFines;
    }
    
    public void addOldFine(double toAdd)
    {
        oldFines += toAdd;
    }
    
    public void setOldFines(double newValue)
    {
        oldFines = newValue;
    }

}
