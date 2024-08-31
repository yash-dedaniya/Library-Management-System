package com.Library;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

    public Book(String isbn,String title,String author,int publicationYear){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }

    // Getter methods for getting isbn, title, author, publicationYear and isAvaialable status
    public String getIsbn(){
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublicationYear(){
        return publicationYear;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void borrow(){
        isAvailable = false;
    }

    public void returnBook(){
        isAvailable = true;
    }
}
