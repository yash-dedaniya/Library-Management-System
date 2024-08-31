package com.Library;

// Import ArrayList class for creating dynamic list of books
import java.util.ArrayList;
// Import List interface for working with collections of books
import java.util.List;

public class Library
{
    public List<Book> books;

    // Initializes the books list to an empty ArrayList when a new Library object is created
    public Library()
    {
        books = new ArrayList<Book>();
    }

    // For adding a book addBook method is created
    public boolean addBook(Book book){
        for(Book b : books){
            if(b.getIsbn().equals(book.getIsbn())){
                return false;
            }
        }
        books.add(book);
        return true;
    }

    public Book borrowBook(String isbn){
        // checking that required book is available or not currently from list of books
        for(Book book : books){
            if(book.getIsbn().equals(isbn) && book.isAvailable()){
                book.borrow();
                return book;
            }
        }
        return null; // Book not found or not available
    }

    public void returnBook(Book book){
        // checking that returned book belongs to our list of books and currently its availability status is false
        if(books.contains(book) && !book.isAvailable()){
            book.returnBook();
        }
    }

    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = new ArrayList<Book>();

        // Checking for each book that if it is available then its added to availableBooks arrayList and then this list of all available book is returned
        for(Book book : books){
            if(book.isAvailable()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
