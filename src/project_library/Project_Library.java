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
    
    //***** addBook ******************
    public static void addBook(Book[] books)
    {//begin of addBook
       
        Book newBook = new Book();
        Scanner keyboard = new Scanner(System.in);
        int response;
        do
        {//begin outer do while
            //set book ID number
            int bookID = findNextBook(books);
            newBook.setBookID(bookID);
           
            //prompt user to input book information
            System.out.println("\nPlease enter the following information "
                    + "for the new book: ");
           
            //set title, author, summary, condition, and purchase price
            System.out.println("Title");
            System.out.print(": ");
            String title = keyboard.nextLine();
            newBook.setTitle(title);
            System.out.println("Author");
            System.out.print(": ");
            String author = keyboard.nextLine();
            newBook.setAuthor(author);
            System.out.println("Book Summary");
            System.out.print(": ");
            String summary = keyboard.nextLine();
            newBook.setSummary(summary);
            System.out.println("Condition (new, fair, or poor");
            System.out.print(": ");
            String condition = keyboard.nextLine();
            newBook.setCondition(condition);
            System.out.println("Purchase Price");
            System.out.print(": ");
            Double price = keyboard.nextDouble();
            newBook.setPrice(price);
           
            //set age restricted or not      
            int restricted;
            boolean yesNoRestricted = true;
            do
            {//begin do while
                System.out.print("Restricted to over 18 (enter 1 for yes, 2 for no)");
                System.out.println(": ");
                restricted = keyboard.nextInt();
                switch (restricted)
                {//begin of switch
                    case 1: yesNoRestricted = true; break;
                    case 2: yesNoRestricted = false; break;
                    default: System.out.println("Invalid Option");
                }//end of switch
            }while (restricted != 1 || restricted != 2); //end do while
            newBook.setRestricted(yesNoRestricted);           
           
            //set fiction or non-fiction
            int fiction;
            boolean yesNoFiction = false;
            do
            {//begin do while
                System.out.print("Fiction or Non-Fiction (enter 1 for Fiction, "
                        + "2 for Non-Fiction");
                System.out.println(": ");
                fiction = keyboard.nextInt();
                switch (fiction)
                {//begin of switch
                    case 1: yesNoFiction = true; break;
                    case 2: yesNoFiction = false; break;
                    default: System.out.println("Invalid Option");
                }//end of switch
            }while (fiction != 1 || fiction != 2); //end do while
            newBook.setFiction(yesNoFiction);
           
            //set status, checkedOutBy and checkOutDate to default
            //values for new books
            newBook.setStatus("checked in");
            newBook.setCheckedOutBy(-1);
            newBook.setCheckOutDate("empty");
            
            //save to the books array
            books[bookID] = newBook;
           
            //Print out new book information
            System.out.println("\nThe new book's information is as follows: ");
            System.out.println("Book ID number: "+newBook.getBookID());
            System.out.println("Title: "+newBook.getTitle());
            System.out.println("Author: "+newBook.getAuthor());
            System.out.println("Summary: "+newBook.getDescription());
            System.out.println("Condition: "+newBook.getCondition());
            System.out.println("Price: "+newBook.getPrice());
            System.out.print("Restricted to over 18: ");
            if(newBook.Restricted())
                System.out.println("yes");
            else
                System.out.println("no");
            System.out.print("Fiction or Non-Fiction: ");
            if(newBook.Fiction())
                System.out.println("Fiction");
            else
                System.out.println("Non-Fiction");

            //ask if user wants to add another book
            do
            {//begin inner do while
                System.out.println("\nWould you like to add another book?"
                            + "\nEnter 1 for yes, 2 for no.");
                System.out.print(": ");
                response = keyboard.nextInt();
                if (response != 1 || response !=2)
                    System.out.println("Invalid Option");
            }while (restricted != 1 || restricted != 2); //end inner do while
           
        }while(response == 1);  //end outer do while
    }//end of addBook 

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
            System.out.println("[2] Edit Patron");
            System.out.println("[3] List All Patrons");
            System.out.println("[4] Check Patron's Fines");
            System.out.println("[5] Exit To Main Menu\n");
            System.out.print(": ");
            response = keyboard.nextInt();

            switch (response)
            {
                case 1:addPatron(patrons);break;
                case 2:editPatrons(patrons);break;
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
            System.out.println("Enter patron's email address.");
            System.out.print(": ");
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
    public static void editPatrons(Patron[] patrons)
    {//begin of searchEditPatron
        Scanner keyboard = new Scanner(System.in);
        int ID=100;
        int response;

        //display all patrons
        for (int id=0; id<patrons.length;id++)
        {
            if (patrons[id].isSet())
                System.out.println("ID: "+id+" - "+patrons[id].getFirstName()+
                        " "+patrons[id].getLastName());
        }

        //actually edit stuff
        do
        {//begin do
        System.out.println("Enter the Patrons ID who you would like to edit.");
        System.out.println("To go back to the Patrons option menu enter [-1]");
        System.out.print(": ");
        String patronID = keyboard.nextLine();
        ID = Integer.parseInt(patronID);
        if (ID==-1)
            break;
        do
            {//begin inner do
                System.out.println("Enter what you would like to edit.");
                System.out.println("[1] to edit address.");
                System.out.println("[2] to edit phone number.");
                System.out.println("[3] to edit email address.");
                System.out.println("[4] to edit membership status.");
                System.out.println("[5] to edit City.");
                System.out.println("[6] to edit State.");
                System.out.println("[7] to edit Zipcode.");
                System.out.println("[8] to edit First Name.");
                System.out.println("[9] to edit Last Name.");
                System.out.println("[10] to edit Birthday.");
                System.out.println("[0] to Finish editing Patron Info.");
                System.out.print(": ");
                response = keyboard.nextInt();
                keyboard.nextLine(); //absorb extra newline.
                switch (response)
                {//begin switch
                    case 1: {System.out.println("Enter new address"); System.out.print(": ");
                             String street = keyboard.nextLine();
                             patrons[ID].setStreet(street);break;}
                    case 2: {System.out.println("Enter new Phone number.");System.out.print(": ");
                             String phone = keyboard.nextLine();
                             patrons[ID].setPhone(phone);break;}
                    case 3: {System.out.println("Enter new email address");System.out.print(": ");
                             String email = keyboard.nextLine();
                             patrons[ID].setEmail(email);break;}
                    case 4:{System.out.println("Enter new memebership status");System.out.print(": ");
                             String membershipStatus = keyboard.nextLine();
                             patrons[ID].setMembershipStatus(membershipStatus);break;}
                                
                    case 5:{System.out.println("Enter new City");
                            System.out.print(": ");
                             String city = keyboard.nextLine();
                             patrons[ID].setCity(city);break;}
                    case 6:{System.out.println("Enter new State");System.out.print(": ");
                             String state = keyboard.nextLine();
                             patrons[ID].setState(state);break;}
                    case 7:{System.out.println("Enter new Zipcode");System.out.print(": ");
                             String zipcode = keyboard.nextLine();
                             patrons[ID].setZipCode(zipcode);break;}
                    case 8:{System.out.println("Enter new First Name");System.out.print(": ");
                             String firstName = keyboard.nextLine();
                             patrons[ID].setFirstName(firstName);break;}
                    case 9: {System.out.println("Enter new Last Name");System.out.print(": ");
                             String lastName = keyboard.nextLine();
                             patrons[ID].setLastName(lastName);break;}
                    case 10: {System.out.println("Enter new Birthday");System.out.print(": ");
                             String birthday = keyboard.nextLine();
                             patrons[ID].setBirthday(birthday);break;}
                    default: System.out.println("Invalid Option");
                }//end switch

            }//end inner do
                while(response!=0);

        System.out.println("The following is the new information for the patron:");
        System.out.println("\nThe new patron's information is as follows: ");
            System.out.println("Patron ID number: "+patrons[ID].getPatronID());
            System.out.println("Name: "+patrons[ID].getFirstName()+" "+
                    patrons[ID].getLastName());
            System.out.println("Address: "+patrons[ID].getStreet()
                    +", "+patrons[ID].getCity()+
                    ", "+patrons[ID].getState()+
                    ", "+patrons[ID].getZipCode());
            System.out.println("Phone number: "+patrons[ID].getPhone());
            System.out.println("Email address: "+patrons[ID].getEmail());
            System.out.println("Membership status: "
                    +patrons[ID].getMembershipStatus());
            System.out.println("Birthday: "+patrons[ID].getBirthday());
            System.out.print(": ");



        }//end Do
        while(ID!=-1);

        ;
    }//end of searchEditPatron

    //***** addPatron ******************
    public static void listPatrons(Patron[] patrons)
    {//begin of listPatrons
        for (int i =0; i < patrons.length; i++)
        {
            if (patrons[i].isSet())
            {
                System.out.println("Patron ID number: "+i);
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
        String path = "E:\\School\\bhc\\CS225\\Project_Library\\tmp_project_library.xml";
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
                patrons[i].setBirthday(node.getChildText("Birthday"));
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
        String path = "E:\\School\\bhc\\CS225\\Project_Library\\tmp_project_library.xml";
        File patronXMLFile = new File(path);
        //if the file doesn't exist, ask for a path
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
            for (int id=0; id<patrons.length; id++)
            {
                if (patrons[id].isSet())
                    usedpatrons++;
            }
            
            //create an XML object for each patron, assign all its values
            Element[] savepatrons = new Element[usedpatrons];
            for (int id=0; id<savepatrons.length;id++)
            {//begin for each patron
                savepatrons[id] = new Element("patron");
                savepatrons[id].setAttribute(new Attribute("id",String.valueOf(id)));
                savepatrons[id].addContent(new Element("firstname").setText(patrons[id].getFirstName()));
                savepatrons[id].addContent(new Element("lastname").setText(patrons[id].getLastName()));
                savepatrons[id].addContent(new Element("street").setText(patrons[id].getStreet()));
                savepatrons[id].addContent(new Element("city").setText(patrons[id].getCity()));
                savepatrons[id].addContent(new Element("state").setText(patrons[id].getState()));
                savepatrons[id].addContent(new Element("zipCode").setText(patrons[id].getZipCode()));
                savepatrons[id].addContent(new Element("phone").setText(patrons[id].getPhone()));
                savepatrons[id].addContent(new Element("email").setText(patrons[id].getEmail()));
                savepatrons[id].addContent(new Element("membershipStatus").setText(patrons[id].getMembershipStatus()));
                savepatrons[id].addContent(new Element("Birthday").setText(patrons[id].getBirthday()));
                savepatrons[id].addContent(new Element("Fines").setText(String.valueOf(patrons[id].getFine())));
                savepatrons[id].addContent(new Element("specialFines").setText(String.valueOf(patrons[id].getSpecialFine())));
                
                
                //save the checked books
                int[] checkedbooks = patrons[id].getCheckedBooks();
                String checkedBooksString = "";
                for (int bookID =0; bookID<checkedbooks.length; bookID++)
                {
                    //creates a comma-delimited list of the checked books array
                    checkedBooksString=checkedBooksString+String.valueOf(checkedbooks[bookID]);
                    //do not put an extra comma at the end
                    if (bookID != checkedbooks.length-1)
                        checkedBooksString = checkedBooksString+",";
                }
                //save out the new list
                savepatrons[id].addContent(new Element("checkedBooks").setText(checkedBooksString));
                
                //add the now-finished xml object to the document
                doc.getRootElement().addContent(savepatrons[id]);
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
    
        public static int findNextBook(Book[] books)
    {
        int NextID=-1;
        for (int i = 0; i < books.length; i++)
        {
            if (books[i].isSet())
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
