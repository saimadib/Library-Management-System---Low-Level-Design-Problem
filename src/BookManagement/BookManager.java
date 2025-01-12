package BookManagement;

import java.util.HashMap;
import java.util.Map;

public class BookManager {
    // map of books with key as the ISBN of the book
    private Map<String, Book> books;
    private int numBooks;
    private int maxBooks;

    // Constructor
    public BookManager(int maxBooks){
        numBooks = 0;
        this.maxBooks = maxBooks;
        books = new HashMap<>();
    }

    // AddBook to the inventory
    public void addBook(Book book){
        if(numBooks < maxBooks){
            books.put(book.getISBN(), book);
            numBooks++;
        }
    }

    // RemoveBook from the inventory
    public void removeBook(Book book){
        if(books.remove(book.getISBN()) != null){
            numBooks--;
        }
    }

    // UpdateBook details
    public void updateBook(Book book, String title, String author, String ISBN, int publicationYear){
        if(books.containsKey(book.getISBN())){
            book.setTitle(title);
            book.setAuthor(author);
            book.setISBN(ISBN);
            book.setPublicationYear(publicationYear);
        }
    }

    public void printInventory(){
        for(Book book : books.values()){
            System.out.println(book.getTitle());
        }
    }

    public Book searchByTitle(String title){
        for(Book book : books.values()){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public Book searchByAuthor(String author){
        for(Book book : books.values()){
            if(book.getAuthor().equals(author)){
                return book;
            }
        }
        return null;
    }

    public Book searchByISBN(String ISBN){
        return books.get(ISBN);
    }

    public Book searchByPublicationYear(int publicationYear){
        for(Book book : books.values()){
            if(book.getPublicationYear() == publicationYear){
                return book;
            }
        }
        return null;
    }

    // check if the book is available for borrowing
    public boolean isBookAvailable(Book book){
        if(books.containsValue(book)){
            return !book.getIsBorrowed();
        }
        return false;
    }
}
