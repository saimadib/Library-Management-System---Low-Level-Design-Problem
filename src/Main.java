
import BookManagement.Book;
import LibraryManagement.Library;
import PatronManagement.Patron;

public class Main {
    public static void main(String[] args) {
        // Create a new library
        Library library = new Library("City Library", "123 Main St", 100);

        // Add books to the library
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", 1925);
        library.addBook("1984", "George Orwell", "9780451524935", 1949);

        // Add patrons to the library
        library.addPatron("John Doe", "john.doe@example.com", "555-1234");
        library.addPatron("Jane Smith", "jane.smith@example.com", "555-5678");

        // Search for a book by title
        Book book = library.searchByTitle("1984");
        if (book != null) {
            System.out.println("Found book: " + book.getTitle() + " by " + book.getAuthor());
        }

        // Search for a patron by email
        Patron patron = library.searchByEmail("john.doe@example.com");
        if (patron != null) {
            System.out.println("Found patron: " + patron.getName() + " with email " + patron.getEmail());
        }

        // Borrow a book
        library.borrowBook("john.doe@example.com", "9780451524935");

        // Return a book
        library.returnBook("john.doe@example.com", "9780451524935");

        // Display library information
        library.display();
    }
}