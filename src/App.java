// Imports of files from respective folders
import Library.Library;
import Book.Book;
// Scanner import to use scanner in app
import java.util.Scanner;

public class App {

    // Colors for menu options
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        // Create a library OBJECT 
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main loop for the app
        while (running) {
            // Menu options
            System.out.println(GREEN + "Welcome user! Select an option: " + RESET);
            System.out.println(GREEN + "1. Add a book to the library." + RESET);
            System.out.println(GREEN + "2. Search for a book by name" + RESET);
            System.out.println(GREEN + "3. List all available books" + RESET);
            System.out.println(GREEN + "4. Return a book" + RESET);
            System.out.println(GREEN + "5. Loan a book." + RESET);
            System.out.println(RED + "6. Exit" + RESET);
            System.out.println(GREEN + "Enter your choice: " + RESET);

            // Reads user input and triggers menu switch case options
            int choice = scanner.nextInt();
            scanner.nextLine(); // Reads user input and returns in console as string

            switch (choice) {
                case 1:
                    // Get book details from user
                    System.out.println("Enter name of book: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter author of book: ");
                    String author = scanner.nextLine();

                    System.out.println("Enter year of book: ");
                    int year = scanner.nextInt();

                    System.out.println("Enter edition: ");
                    int edition = scanner.nextInt();

                    scanner.nextLine(); // Reads user input and returns in console as string

                    System.out.println("Is the book available to loan out?");
                    boolean isAvailable = scanner.nextBoolean();

                    // Add book to library
                    Book newBook = new Book(name, author, year, edition, isAvailable);
                    library.addBook(newBook);
                    break;

                case 2:
                    // Search for a book
                    System.out.println(GREEN + "Search for a book by name: " + RESET);
                    String search = scanner.nextLine();
                    library.searchBook(search);
                    break;

                case 3:
                    // List AVAILABLE books
                    library.listAvailableBooks();
                    break;

                case 4:
                    // Return a book
                    System.out.println(GREEN + "Insert the name of the book you wish to return: " + RESET);
                    String returnBookName = scanner.nextLine();
                    library.returnBook(returnBookName);
                    break;

                case 5:
                    library.loanBook(scanner);
                    break;

                case 6:
                    // Exit app
                    System.out.println(RED + "Exiting program..." + RESET);
                    running = false;
                    break;
                    
                default:
                    // Invalid input error handling
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
