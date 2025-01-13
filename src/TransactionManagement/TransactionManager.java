package TransactionManagement;

import BookManagement.Book;
import PatronManagement.Patron;

import java.util.*;

public class TransactionManager {
    // Contain the list of borrowing history
    private List<Transaction> borrowingHistory;
    private Map<Book, Queue<Patron>> reservations;

    // Constructor
    public TransactionManager(){
        this.borrowingHistory = new ArrayList<>();
        this.reservations = new HashMap<>();
    }

    // Add Transaction to the borrowingHistory list
    public void borrowBook(Book book, Patron patron){
        if (book == null || patron == null) {
            System.out.println("Book or Patron is null");
            return;
        }
        if(book.getIsBorrowed()){
            System.out.println("Book is already borrowed");
            return;
        }
        if (reservations.containsKey(book) && !reservations.get(book).isEmpty()) {
            Queue<Patron> reservationQueue = reservations.get(book);
            if (!reservationQueue.peek().equals(patron)) {
                System.out.println("Book is reserved by another patron");
                return;
            } else {
                reservationQueue.poll(); // Remove the patron from the reservation queue
            }
        }
        Transaction record = new Transaction(book, patron, new Date());
        borrowingHistory.add(record);
    }

    // Remove Transaction from the borrowingHistory list
    public void returnBook(Book book, Patron patron){
        for(Transaction record : borrowingHistory){
            if(record.getBook().equals(book) && record.getPatron().equals(patron)){
                record.setReturnedDate(new Date());
                book.setIsBorrowed(false);
            }
        }

        if (reservations.containsKey(book) && !reservations.get(book).isEmpty()) {
            Patron nextPatron = reservations.get(book).poll();
            System.out.println("Book is now reserved for " + nextPatron.getEmail());
        }
    }

    public void reserveBook(Book book, Patron patron) {
        reservations.putIfAbsent(book, new LinkedList<>());
        reservations.get(book).add(patron);
        System.out.println("Book reserved successfully for " + patron.getEmail());
    }

    // Getters and Setters
    public List<Transaction> getBorrowingHistory(){
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<Transaction> borrowingHistory){
        this.borrowingHistory = borrowingHistory;
    }

}
