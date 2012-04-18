/* Name:                Jacob Burkamper
 * Program:             project_library
 * Problem Statement:   A program to do something
 * Input:               something is unput
 * Output:              something is output
*/

package project_library;
import java.util.Scanner;
/**
 *
 * @author jacob
 */
public class Project_Library
{ //begin Project_Library

    public static void main(String[] args) 
    { // begin main
        DisplayWelcome();
        Library library = loadLibrary();
        Patron[] patrons = loadPatrons();
        Book[] books = loadBooks();
        if ( askPassword(library) )
            MainMenu(library,patrons,books);
        
        saveLibrary(library);
        savePatrons(patrons);
        saveBooks(books);
        System.exit(0);
    } //End main
    
    public static void DisplayWelcome()
    {
        System.out.println();
        System.out.println("##################################################################");
        System.out.println("######      Welcome to the Library Management System!     ########");
        System.out.println("######         It was designed by Team Enterprise         ########");
        System.out.println("######  It was commissioned by Black Hawk College, CS225  ########");
        System.out.println("######        For the City of Happyville, Illinois        ########");
        System.out.println("##################################################################");
        System.out.println();
    }
    
    public static boolean askPassword(Library library)
    {
        System.out.println("This is the method which asks for the password");
        System.out.println("It has not yet been implimented, so we'll just let you in");
        return true;
    }
    
    public static Book[] loadBooks()
    {
        Book[] books = new Book[2];
        System.out.println("The Books will be loaded here!");
        return books;
    }
    
    public static Patron[] loadPatrons()
    {
        Patron[] patrons = new Patron[2];
        System.out.println("The Patrons will be loaded here!");
        return patrons;
    }
    
    public static Library loadLibrary()
    {
        Library library = new Library();
        System.out.println("The Library settings will be loaded here!");
        return library;
    }
    
    public static void saveLibrary(Library library)
    {
        System.out.println("This method would save the library settings");
    }
    
    public static void savePatrons(Patron[] patrons)
    {
        System.out.println("This method would save the Patrons");
    }
    
    public static void saveBooks(Book[] books)
    {
        System.out.println("This method would save the books");
    }
    
    public static void MainMenu(Library library, Patron[] patrons, Book[] books)
   {//begin mainMenu
       Scanner keyboard = new Scanner(System.in);
       int next;
       boolean nextLoop = true;
       do
       {//begin do
       System.out.println("Library Management");
       System.out.println("Please select your action:");
       System.out.println("1. Patron Reords");
       System.out.println("2. Book Records");
       System.out.println("3. Checkout Book");
       System.out.println("4. Checkin Book");
       System.out.println("5. Library Settings");
       System.out.println("6. Exit");
       System.out.print(": ");
       next = keyboard.nextInt();
       switch (next)
       {//begin switch
           case 1: PatronRecordsMenu(); break;
           case 2: BookRecordsMenu(); break;
           case 3: CheckoutBook(); break;
           case 4: CheckinBook(); break;
           case 5: LibrarySettingsMenu(); break;
           case 6: nextLoop = false; break;
       }//end switch
       }while (nextLoop);//end do
   }//end mainMenu
   
   public static void PatronRecordsMenu()
   {
       System.out.println("You are at the Patron Records Menu");
   }
   
   public static void BookRecordsMenu()
   {
       System.out.println("You are at the Book Records Menu");
   }
   
   public static void CheckoutBook()
   {
       System.out.println("You are at the Checkout Books Menu");
   }
   
   public static void CheckinBook()
   {
       System.out.println("You are at the Checkin Books Menu");
   }
   
   public static void LibrarySettingsMenu()
   {
       System.out.println("You are at the Library Settings Menu");
   }

} //End Project_Library
