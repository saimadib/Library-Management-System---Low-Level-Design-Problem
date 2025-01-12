package LibraryManagement;

import BookManagement.Book;
import BookManagement.BookManager;
import PatronManagement.Patron;
import PatronManagement.PatronManager;
import TransactionManagement.TransactionManager;

public class Library {
    private String name;
    private String address;
    private PatronManager patronManager;
    private BookManager bookManager;
    private TransactionManager transactionManager;

    // Constructor
    public Library(String name, String address, int maxBooks) {
        this.name = name;
        this.address = address;
        this.bookManager = new BookManager(maxBooks);
        this.patronManager = new PatronManager();
        this.transactionManager = new TransactionManager();
    }

    // Allow user to add book to the library
    public void addBook(String title, String author, String ISBN, int publicationYear) {
        Book book = new Book(title, author, ISBN, publicationYear);
        bookManager.addBook(book);
    }

    // Allow user to remove book from the library
    public void removeBook(String ISBN) {
        Book book = bookManager.searchByISBN(ISBN);
        if (book != null) {
            bookManager.removeBook(book);
        }
    }

    // Allow user to update book details
    public void updateBook(String ISBN, String title, String author, int publicationYear) {
        Book book = bookManager.searchByISBN(ISBN);
        if (book != null) {
            bookManager.updateBook(book, title, author, ISBN, publicationYear);
        }
    }

    // Allow user to search book by title
    public Book searchByTitle(String title) {
        return bookManager.searchByTitle(title);
    }

    public Book searchByAuthor(String author) {
        return bookManager.searchByAuthor(author);
    }

    public Book searchByISBN(String ISBN) {
        return bookManager.searchByISBN(ISBN);
    }

    // Allow user to add patron to the library
    public void addPatron(String name, String email, String phoneNumber) {
        Patron patron = new Patron(name, email, phoneNumber);
        patronManager.addPatron(patron);
    }

    // Allow user to remove patron from the library
    public void removePatron(String email) {
        Patron patron = patronManager.searchByEmail(email);
        if (patron != null) {
            patronManager.removePatron(patron);
        }
    }

    // Allow user to update patron details
    public void updatePatron(String email, String name, String phoneNumber) {
        Patron patron = patronManager.searchByEmail(email);
        if (patron != null) {
            patronManager.updatePatron(patron, name, email, phoneNumber);
        }
    }

    // Allow user to search patron by name
    public Patron searchByEmail(String email) {
        return patronManager.searchByEmail(email);
    }

    // Allow user to borrow book
    public void borrowBook(String patronEmail, String ISBN) {
        Patron patron = patronManager.searchByEmail(patronEmail);
        Book book = bookManager.searchByISBN(ISBN);
        if (patron != null && book != null) {
            transactionManager.borrowBook(book,patron);
        }
    }

    // Allow user to return book
    public void returnBook(String patronEmail, String ISBN) {
        Patron patron = patronManager.searchByEmail(patronEmail);
        Book book = bookManager.searchByISBN(ISBN);
        if (patron != null && book != null) {
            transactionManager.returnBook(book,patron);
        }
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
}
