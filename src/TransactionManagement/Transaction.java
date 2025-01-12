package TransactionManagement;

import BookManagement.Book;
import PatronManagement.Patron;

import java.util.Date;

public class Transaction {
    private Book book;
    private Patron patron;
    private Date borrowedDate;
    private Date returnedDate;

    // Constructor
    public Transaction(Book book, Patron patron, Date borrowedDate) {
        this.book = book;
        this.patron=patron;
        this.borrowedDate = borrowedDate;
        this.book.setIsBorrowed(true);
    }

    // Getters and Setters
    public Book getBook() {
        return book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}
