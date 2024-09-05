package Book;

public class Book {
    private String name;
    private String author;
    private int year;
    private int edition;
    private boolean isAvailable = true;
    
    // Book object
    public Book (String name, String author, int year, int edition, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.isAvailable = isAvailable;
    }

    // Getters

    // Get book name
    public String getName() {
        return name;
    }
    
    // Get author 
    public String getAuthor() {
        return author;
    }

    // Get year
    public int getYear() {
        return year;
    }

    // Get edition
    public int getEdition() {
        return edition;
    }

    // Get isAvailable (default is true)
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters 

    // This is for return book class. Sets setAvailable = isAvailable
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Loan book (not used but still in code for reference)
    public void loan() {
        if(isAvailable) {
            System.out.println("Book is available");
            isAvailable = false;
        } else {
            System.out.println("Book is not available");
        }
    }

    // Return book
    public void returnBook() {
        if(isAvailable) {
            System.out.println("Book is already in library.");
        } else {
            System.out.println("Returning the book...");
            isAvailable = true;
        }
    }

    // toString method to be able to see books inside array in string format
    @Override
    public String toString() {
        return "Name: " + name + ", Author: " + author + ", Year: " + year + ", Edition: " + edition + ", Availability: " + isAvailable;
    }
}
