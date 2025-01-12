package BookManagement;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int publication_year;
    public Boolean isBorrowed;

    // Constructor
    public Book(String title, String author, String ISBN, int publicationYear){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.publication_year=publicationYear;
        this.isBorrowed=false;
    }

    // Getters
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public int getPublicationYear(){
        return publication_year;
    }

    public boolean getIsBorrowed(){
        return isBorrowed;
    }

    // Setters
    public void setTitle(String title){
        this.title=title;
    }

    public void setAuthor(String author){
        this.author=author;
    }

    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }

    public void setPublicationYear(int publicationYear){
        this.publication_year=publicationYear;
    }

    public void setIsBorrowed(boolean isBorrowed){
        this.isBorrowed=isBorrowed;
    }

}
