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

    // borrow method make availability status as false after book borrowed by a user
    public void borrow(){
        isAvailable = false;
    }

    // returnBook method make availability status of book as true after it has returned back
    public void returnBook(){
        isAvailable = true;
    }
}
