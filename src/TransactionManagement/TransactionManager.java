package TransactionManagement;

import BookManagement.Book;
import PatronManagement.Patron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {
    // Contain the list of borrowing history
    private List<Transaction> borrowingHistory;

    // Constructor
    public TransactionManager(){
        this.borrowingHistory = new ArrayList<>();
    }

    // Add Transaction to the borrowingHistory list
    public void borrowBook(Book book, Patron patron){
        if(book.getIsBorrowed()){
            System.out.println("Book is already borrowed");
            return;
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
    }
    // Getters and Setters
    public List<Transaction> getBorrowingHistory(){
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<Transaction> borrowingHistory){
        this.borrowingHistory = borrowingHistory;
    }

}
