package com.Library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Creating LibraryTest class for unit testing of the Library Class
public class LibraryTest
{
    private Library library;

    // Initializes a new Library object before each test with the help of @BeforeEach annotation of JUnit 5
    @BeforeEach
    void setUp(){
        library = new Library();
    }

    // This test ensures that a new book can be added successfully
    @Test
    void testAddBook(){
        Book book = new Book("27102003","ABCD","Author1",2008);
        library.addBook(book);

        /*Test Case 1 : False expectation
        Assertions.assertEquals(0,library.getAvailableBooks().size());

        It gives an error because after adding a book actual result is 1
        But we gave false value as 0 so our function works correct
         */

        // Test Case 2 : True expectation
        Assertions.assertEquals(1,library.getAvailableBooks().size());
        Assertions.assertEquals(book,library.getAvailableBooks().get(0));
        System.out.println("Test case need to run successfully");
        // It runs correctly as we gave 1 as expected result and its equal to actual result
    }

    // This test ensures that book with duplicate ISBN is not allowed to add again if already added
    @Test
    void testAdBookWithDuplicateISBN(){
        Book book1 = new Book("27102004","ADCB","Author2",2006);
        Book book2 = new Book("27102004","ADCE","Author3",2007);
        library.addBook(book1);

        Assertions.assertFalse(library.addBook(book2));// Expecting false because isbn of book is same
        System.out.println("Test Case run successfully because due to duplicate isbn book is not added");
    }

    // This test ensures that book is borrowed by user successfully and its availability status set to false
    @Test
    void testBorrowBook(){
        Book book = new Book("27102003","XYZW","Author1",2002);
        library.addBook(book);

        Book borrowedBook = library.borrowBook("27102003");
        Assertions.assertNotNull(borrowedBook); // Test case run correctly if book with given ISBN was borrowed successfully

        // If book is Borrowed then its isAvailable status is false which is checked by following Assertion
        Assertions.assertFalse(borrowedBook.isAvailable());

        System.out.println("Both results are matched and test case run successfully");
    }

    // This test ensures that already borrowed book can not be borrowed again.
    @Test
    void testBorrowBookWhenIsAlreadyBorrowed(){
        Book book = new Book("12345678","YASH","Author1",2009);
        library.addBook(book);

        // Borrow the book once
        library.borrowBook("12345678");

        // Attempt to borrow the same book again
        Book borrowedBook = library.borrowBook("12345678");

        // Assert that the borrowed book is null, indicating that the book is not available
        Assertions.assertNull(borrowedBook);
        System.out.println("Test Case run successfully");
    }

    // This test ensures that borrowed book is returned successfully and its availability is changed to true
    @Test
    void testReturnBook(){
        Book book = new Book("722077","PQRS","Author1",1999);
        library.addBook(book);

        // First borrow a that book so isAvailable set to false
        library.borrowBook("722077");

        // Return that book so isAvailable set to true
        library.returnBook(book);

        // Checking that isAvailable set to true or not with following assertion
        Assertions.assertTrue(book.isAvailable());
        System.out.println("Test case run successfully and book is returned successfully");
    }

    //   This test ensures that the returnBook does not modify availability of a book that hasn't been borrowed
    @Test
    void testReturnBookWhenIsNotBorrowed(){
        Book book = new Book("722077","PQRS","Author1",1999);
        library.addBook(book);

        // Attempt to return a book that has not been borrowed
        library.returnBook(book);

        // Assert that the book is still available
        Assertions.assertTrue(library.getAvailableBooks().contains(book));
        System.out.println("Test case runs successfully and isAvailable is not modified");
    }
    void testGetAvailableBooks(){
        Book book1 = new Book("25052080","HLMN","Author10",2023);
        Book book2 = new Book("25052050","HKYN","Author11",2024);
        Book book3 = new Book("25052010","HLON","Author12",2020);

        // Adding books
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Borrowing one book with ISBN="25052080"
        library.borrowBook("25052080");

        // Check that now books ArrayList size is 2 or not using getAvailableBooks function which return list of available books
        Assertions.assertEquals(2,library.getAvailableBooks().size());

        // Check whether 2nd book has publication year 2020 according to created test case scenario
        Assertions.assertEquals(2020,library.getAvailableBooks().get(1).getPublicationYear());
    }
}
