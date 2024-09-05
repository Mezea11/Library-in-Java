package Library;
import java.util.ArrayList;
import java.util.Scanner;
import Book.Book;

public class Library {
    private ArrayList<Book> library;

    // Constructor for Library
    public Library() {
        library = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book newBook) {
        library.add(newBook);
        System.out.println("Book has been added to the library.");
    }

    // Search for a book by name
    public void searchBook(String searchName) {
        boolean found = false;
        for (Book book : library) {
            if (book.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Book found: " + book.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // List all available books
    public void listAvailableBooks() {
        System.out.println("Here’s a list of available books: ");
        for (Book book : library) {
            if (book.isAvailable()) {
                System.out.println(book.toString());
            }
        }
    }

    // Return a book
    public void returnBook(String bookName) {
        boolean bookFound = false;
        // Loops through array of books
        for (Book book : library) {
            // If users search input matches book in array then bookFound == true
            if (book.getName().equalsIgnoreCase(bookName)) {
                bookFound = true;
                // if isAvailable == false then you can return it
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("The book has been successfully returned.");
                // if isAvailable == true then you cant return it
                } else {
                    System.out.println("The book is already available.");
                }
                break;
            }
        }
        // if bookFound == false then book cant be searched
        if (!bookFound) {
            System.out.println("Book not found in the library.");
        }
    }

/*         public void loan() {
        if(isAvailable) {
            System.out.println("Book is available");
            isAvailable = false;
        } else {
            System.out.println("Book is not available");
        }
    } */

    public void loanBook(Scanner scanner) {
        System.out.println("Insert name of the book you wish to loan: ");
        String bookName = scanner.nextLine(); // Read the name of the book
        
        boolean bookFound = false;
        // For loop that goes through all books in array
        for (Book book : library) {
            // If book.getName == bookName then bookFound is set to true (book is in array)
            if (book.getName().equalsIgnoreCase(bookName)) {
                bookFound = true;

                //If the book is found the user is given the option to loan it with yes/no input
                if (book.isAvailable()) {
                    System.out.println(book.toString());
                    System.out.println("Do you wish to loan this book? (yes/no)");
                    
                    String choice = scanner.nextLine(); // Reuse the Scanner passed from main
                    
                    //If the users input is yes then isAvailable is set to false, book is not available in searchBook or loanBook
                    if (choice.equalsIgnoreCase("yes")) {
                        book.setAvailable(false);
                        System.out.println("The book has been successfully loaned.");
                    }
                    
                    // Simple error handle that triggers if the book isAvailable == false
                } else {
                    System.out.println("The book is already loaned.");
                }
                break;
            }
        }
        // bookFound default is set to true, if bookFound == false then you cant search for it
        if (!bookFound) {
            System.out.println("Book not found.");
        }
    }
}