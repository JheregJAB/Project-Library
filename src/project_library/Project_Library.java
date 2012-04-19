/* Name:                Team Enterprise
 * Program:             project_library
 * Problem Statement:   A program to manage a library
 * Input:               Library settings, books, patrons, lots of menu options
 * Output:              Whatever the user asks for, as far as the above.
*/

package project_library;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
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
    
    public static void MainMenu(Library library, Patron[] patrons, Book[] books)
   {//begin mainMenu
       Scanner keyboard = new Scanner(System.in);
       int next;
       boolean nextLoop = true;
       do
       {//begin do
       System.out.println("Library Management");
       System.out.println("Please select your action:");
       System.out.println("1. Patron Records");
       System.out.println("2. Book Records");
       System.out.println("3. Checkout Book");
       System.out.println("4. Checkin Book");
       System.out.println("5. Library Settings");
       System.out.println("6. Exit");
       System.out.print(": ");
       next = keyboard.nextInt();
       switch (next)
       {//begin switch
           case 1: PatronOptions(patrons); break;
           case 2: BooksMenu(); break;
           case 3: CheckoutBook(); break;
           case 4: CheckinBook(); break;
           case 5: LibrarySettingsMenu(); break;
           case 6: nextLoop = false; break;
       }//end switch
       }while (nextLoop);//end do
   }//end mainMenu


    public static void BooksMenu()
    {//begin BooksMenu
        Scanner keyboard = new Scanner(System.in);
        String WelcomeMenu;
        int MenuOption;

        System.out.println("This is the Books Option Menu.");

        do
        {//begin do
       System.out.println("Enter the option you want"
                + "to do:\n [1] to Search for books."
                + "\n [2] to list all the books."
                + "\n [3] to Edit the books."
                + "\n [0] to Exit to the main menu");
       System.out.print(": ");
       WelcomeMenu = keyboard.nextLine();
        MenuOption= Integer.parseInt(WelcomeMenu);

        switch (MenuOption)
        {//begin switch
            case 0: break;
            case 1: BookSearch();break;
            case 2: AllBooks();break;
            case 3: EditBooks();break;
            default:System.out.println("Invalid Option"); break;
        }//end switch

        }//end do
        while(MenuOption!=0);

        System.out.println("End of Books Menu.");


    }//end BooksMenu

        public static void EditBooks()
    {//begin EditBooks
        Scanner keyboard = new Scanner(System.in);
        System.out.println("This is the Edit Books Method.");
        String EditOptions;
        int EditOptionsChoice;

       do
       {//begin Do
       System.out.println("Edit Books Options"
                + "\n[1] to change book status."
                + "\n[2] to change the books condition."
                + "\n[3] to go back to the  EditBooks Menu.");
       System.out.print(": ");
       EditOptions = keyboard.nextLine();
        EditOptionsChoice = Integer.parseInt(EditOptions);
        switch (EditOptionsChoice)
        {//begin Switch
            case 0: break;
            case 1: EditBookStatus();break;
            case 2: EditBookCondition();break;
            default:System.out.println("Invalid Option"); break;
        }//end Switch
       }//end Do
       while (EditOptionsChoice!=3);
    }//end EditBooks

    public static void BookSearch()
    {//begin BookSearch
        System.out.println("This is the Book Search Method.");
    }//end BookSearch

    public static void AllBooks()
    {//begin AllBooks
        System.out.println("This is the All Books method.");
    }//end AllBooks



        //***** PatronOptions ****************
    public static void PatronOptions(Patron[] patrons)
    {//begin of PatronOptions
        Scanner keyboard = new Scanner(System.in);
        int response;

        do 
        { //begin do while

            //Give Patron Options menu and ask user where to go
            System.out.println("Patron Options");
            System.out.println("Please enter the number of the option"
                    + " you would like to select.\n");
            System.out.println("[1] Add Patron");
            System.out.println("[2] Search For And Edit Patron");
            System.out.println("[3] List All Patrons");
            System.out.println("[4] Check Patron's Fines");
            System.out.println("[5] Exit To Main Menu\n");
            System.out.print(": ");
            response = keyboard.nextInt();

            switch (response)
            {
                case 1:addPatron(patrons);break;
                case 2:searchEditPatron(patrons);break;
                case 3:listPatrons(patrons);break;
                case 4:patronFines();break;
                case 5:break;
                default: System.out.println("Invalid Option");
            }

        } while (response != 5); //end do while
    }//end of PatronOptions

    //***** addPatron ******************
    public static void addPatron(Patron[] patrons)
    {//begin of addPatron
        Patron patron = new Patron();
        Scanner keyboard = new Scanner(System.in);
        int response;
        do
        {//begin of do while
            patron.setIsSet();
            System.out.println("\nPlease enter the following information "
                    + "for the new patron: ");
            System.out.println("Enter patron's first name.");
            System.out.print(": ");
            String firstName = keyboard.nextLine();
            patron.setFirstName(firstName);
            System.out.println("Enter patron's last name.");
            System.out.print(": ");
            String lastName = keyboard.nextLine();
            patron.setLastName(lastName);
            System.out.println("Enter patron's street address.");
            System.out.print(": ");
            String street = keyboard.nextLine();
            patron.setStreet(street);
            System.out.println("Enter patron's city.");
            System.out.print(": ");
            String city = keyboard.nextLine();
            patron.setCity(city);
            System.out.println("Enter patron's state.");
            System.out.print(": ");
            String state = keyboard.nextLine();
            patron.setState(state);
            System.out.println("Enter patron's zip code.");
            System.out.print(": ");
            String zipCode = keyboard.nextLine();
            patron.setZipCode(zipCode);
            System.out.println("Enter patron's phone number. "
                + "\nUse format XXX-XXX-XXXX.");
            System.out.print(": ");
            String phone = keyboard.nextLine();
            patron.setPhone(phone);
            System.out.print("Enter patron's email address.");
            System.out.println(": ");
            String email = keyboard.nextLine();
            patron.setEmail(email);           
            System.out.println("Enter patron's membership status - "
                + "\nActive, Retired, Restricted, Suspended "
                + "or Banned");
            System.out.print(": ");
            String membershipStatus = keyboard.nextLine();
            patron.setMembershipStatus(membershipStatus);
            System.out.println("Enter patron's birthday. \nUse format"
                + " mm/dd/yyyy.");
            System.out.print(": ");
            String birthday = keyboard.nextLine();
            patron.setBirthday(birthday);
            patron.setFine(0.0);
            patron.setSpecialFine(0.0);
            patron.setCheckedBooks(-1);
            int patronID = findNextPatron(patrons);
            patrons[patronID] = patron;
           
            System.out.println("\nThe new patron's information is as follows: ");
            System.out.println("Patron ID number: "+patron.getPatronID());
            System.out.println("Name: "+patron.getFirstName()+" "+
                    patron.getLastName());
            System.out.println("Address: "+patron.getStreet()+", "+patron.getCity()+
                    ", "+patron.getState()+", "+patron.getZipCode());
            System.out.println("Phone number: "+patron.getPhone());
            System.out.println("Email address: "+patron.getEmail());
            System.out.println("Membership status: "+patron.getMembershipStatus());
            System.out.println("Birthday: "+patron.getBirthday());
           
            System.out.println("\nWould you like to add another patron?"
                        + "\nEnter 1 for yes, 2 for no.");
            System.out.print(": ");
            response = keyboard.nextInt();       
        }while(response == 1);  //end of do while
    }//end of addPatron

    //***** addPatron ******************
    public static void searchEditPatron(Patron[] patrons)
    {//begin of searchEditPatron
        System.out.println("\nYou are at Search For And Edit Patron.");
    }//end of searchEditPatron

    //***** addPatron ******************
    public static void listPatrons(Patron[] patrons)
    {//begin of listPatrons
        for (int i =0; i < patrons.length; i++)
        {
            if (patrons[i].isSet())
            {
                System.out.println("Patron ID number: "+patrons[i].getPatronID());
            System.out.println("Name: "+patrons[i].getFirstName()+" "+
                    patrons[i].getLastName());
            System.out.println("Address: "+patrons[i].getStreet()+", "+patrons[i].getCity()+
                    ", "+patrons[i].getState()+", "+patrons[i].getZipCode());
            System.out.println("Phone number: "+patrons[i].getPhone());
            System.out.println("Email address: "+patrons[i].getEmail());
            System.out.println("Membership status: "+patrons[i].getMembershipStatus());
            System.out.println("Birthday: "+patrons[i].getBirthday());
            System.out.println("\n");
            }
             else
                continue;
        }
        
    }//end of listPatrons

    //***** addPatron ******************
    public static void patronFines()
    {//begin of patronFines
        System.out.println("\nYou are at Check Patron's Fines.");
    }//end of patronFines

    public static void EditBookStatus()
    {//begin EditBookStatus
      System.out.println("This is the Edit Book Status method"
              + " under the Edit Books method.");
    }//end EditBookStatus

    public static void EditBookCondition()
    {//begin EditBookCondition
        System.out.println("This is the Edit Books Condition"
                + " method under the Edit Books Method.");
    }//end EditBookCondition
   
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
        SAXBuilder builder = new SAXBuilder();
        String path = "/tmp/tmp_project_library.xml";
        File patronXMLFile = new File(path);
        while (! patronXMLFile.exists() )
        {
            path = askForFile(path,"Patron XML File");
            patronXMLFile = new File(path);
        }
        
        try {
            Document document = (Document) builder.build(patronXMLFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("patron");
            
            Patron[] patrons = new Patron[list.size()+10];
            //initialize entire patron array
            for (int i = 0; i < patrons.length; i++)
                patrons[i] = new Patron();
            for (int i = 0; i < list.size(); i++)
            {
                Element node = (Element) list.get(i);
                System.out.println("found patron: "+i);
                patrons[i].setIsSet();
                patrons[i].setFirstName(node.getChildText("firstname"));
                patrons[i].setLastName(node.getChildText("lastname"));
                patrons[i].setStreet(node.getChildText("street"));
                patrons[i].setCity(node.getChildText("city"));
                patrons[i].setState(node.getChildText("state"));
                patrons[i].setZipCode(node.getChildText("zipCode"));
                patrons[i].setPhone(node.getChildText("phone"));
                patrons[i].setEmail(node.getChildText("email"));
                //patrons[i].setRestrictedTo(node.getChildText("restrictedTo"));
                patrons[i].setMembershipStatus(node.getChildText("membershipStatus"));
                patrons[i].setBirthday(node.getChildText("birthday"));
                patrons[i].setFine(Double.parseDouble(node.getChildText("Fines")));
                patrons[i].setSpecialFine(Double.parseDouble(node.getChildText("specialFines")));
                //patrons[i].setCheckedBooks(Integer.parseInt(node.getChildText("checkedBooks")));
                
                //set checkedbooks
                String checkedBooksString = node.getChildText("checkedBooks");
                String[] checkedBooksStringArray = checkedBooksString.split(",");
                int[] checkedBooks = new int[checkedBooksStringArray.length];
                int numtoskip = 0;
                for (int checkedBook = 0; checkedBook < checkedBooksStringArray.length; checkedBook++)
                {
                    if (checkedBooksStringArray[checkedBook].equals(""))
                        continue;
                    else
                        checkedBooks[checkedBook] = Integer.parseInt(checkedBooksStringArray[checkedBook]);
                }
                patrons[i].setCheckedBooks(checkedBooks);
                System.out.println("Patron "+i+"/"+patrons.length);
                System.out.println("isSet? = "+patrons[i].isSet());
                
            }
            return patrons;
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return null;
        
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
        //get the file as needed.
        String path = "/tmp/tmp_project_library.xml";
        File patronXMLFile = new File(path);
        while (!patronXMLFile.exists())
        {
            path = askForFile(path,"Patron XML File");
            patronXMLFile = new File(path);
        }
        
        try {
            //create the XML document
            Element patronfile = new Element("patronfile");
            Document doc = new Document(patronfile);
            doc.setRootElement(patronfile);
            
            //get the total number of used patrons in the array
            int usedpatrons = 0;
            for (int i=0; i<patrons.length; i++)
            {
                if (patrons[i].isSet())
                    usedpatrons++;
            }
            
            //create an XML object for each patron, assign all its values
            Element[] savepatrons = new Element[usedpatrons];
            for (int i=0; i<savepatrons.length;i++)
            {//begin for each patron
                savepatrons[i] = new Element("patron");
                savepatrons[i].setAttribute(new Attribute("id",String.valueOf(i)));
                savepatrons[i].addContent(new Element("firstname").setText(patrons[i].getFirstName()));
                savepatrons[i].addContent(new Element("lastname").setText(patrons[i].getLastName()));
                savepatrons[i].addContent(new Element("street").setText(patrons[i].getStreet()));
                savepatrons[i].addContent(new Element("city").setText(patrons[i].getCity()));
                savepatrons[i].addContent(new Element("state").setText(patrons[i].getState()));
                savepatrons[i].addContent(new Element("zipCode").setText(patrons[i].getZipCode()));
                savepatrons[i].addContent(new Element("phone").setText(patrons[i].getPhone()));
                savepatrons[i].addContent(new Element("email").setText(patrons[i].getEmail()));
                //savepatrons[i].addContent(new Element("restrictedTo").setText(patrons[i].getRestrictedTo()));
                savepatrons[i].addContent(new Element("membershipStatus").setText(patrons[i].getMembershipStatus()));
                savepatrons[i].addContent(new Element("Birthday").setText(patrons[i].getBirthday()));
                savepatrons[i].addContent(new Element("Fines").setText(String.valueOf(patrons[i].getFine())));
                savepatrons[i].addContent(new Element("specialFines").setText(String.valueOf(patrons[i].getSpecialFine())));
                
                
                //save the checked books
                int[] checkedbooks = patrons[i].getCheckedBooks();
                String checkedBooksString = "";
                for (int bookID =0; bookID<checkedbooks.length; bookID++)
                {
                    //savepatrons[i].addContent(new Element("checkedBooks"+bookID).setText(String.valueOf(checkedbooks[bookID])));
                    checkedBooksString=checkedBooksString+String.valueOf(checkedbooks[bookID]);
                    if (bookID != checkedbooks.length-1)
                        checkedBooksString = checkedBooksString+",";
                }
                savepatrons[i].addContent(new Element("checkedBooks").setText(checkedBooksString));
                
                //add the now-finished xml object to the document
                doc.getRootElement().addContent(savepatrons[i]);
            }//end for each patron
            
            //write the file
            XMLOutputter xmlOutput = new XMLOutputter();            
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(path));
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    public static void saveBooks(Book[] books)
    {
        System.out.println("This method would save the books");
    }
    
    public static String askForFile(String path, String filename)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Unable to find file at: "+path);
        System.out.println("Please input the path for: "+filename);
        System.out.print(": ");
        
        String response = userInput.nextLine();
        return response;
    }
    
    public static Patron[] loadTestPatron()
    {
        Patron[] patrons = new Patron[2];
        for (int i = 0; i<patrons.length;i++)
        {
            patrons[i] = new Patron();
            patrons[i].setIsSet();
            patrons[i].setFirstName("Jacob");
            patrons[i].setLastName("Burkamper");
            patrons[i].setStreet("123 Sesame Street");
            patrons[i].setCity("Nowhere");
            patrons[i].setState("IL");
            patrons[i].setZipCode("61234");
            patrons[i].setPhone("555-555-5555");
            patrons[i].setEmail("jacob.burkamper@gmail.com");
            //patrons[i].setRestrictedTo("none");
            patrons[i].setMembershipStatus("Active");
            patrons[i].setBirthday("05641234");
            patrons[i].setFine(0.0);
            patrons[i].setSpecialFine(0.0);
            patrons[i].setCheckedBooks(loadTestBookIDArray());
        }
        return patrons;
    }
    
    public static int[] loadTestBookIDArray()
    {
        int[] bookIDs = new int[3];
        bookIDs[0]=0;
        bookIDs[1]=1;
        bookIDs[2]=2;
        return bookIDs;
    }
    
    public static int findNextPatron(Patron[] patrons)
    {
        int NextID=-1;
        for (int i = 0; i < patrons.length; i++)
        {
            if (patrons[i].isSet())
                continue;
            else
            {
                if (NextID == -1)
                    NextID = i;
            }
        }
        return NextID;
    }

} //End Project_Library
