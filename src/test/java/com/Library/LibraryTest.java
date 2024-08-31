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

    @Test
    // testAddBook is created for to test if a book can be successfully added to the library
    void testAddBook(){
        Book book = new Book("27102003","ABCD","Author1",2008);
        library.addBook(book);

        /*Test Case 1 : False expectation
        Assertions.assertEquals(0,library.getAvailableBooks().size());
        it gives an error because after adding a book actual result is 1
        but we gave false value as 0 so our function works correct
         */

        // Test Case 2 : True expectation
        Assertions.assertEquals(1,library.getAvailableBooks().size());
        Assertions.assertEquals(book,library.getAvailableBooks().get(0));
        System.out.println("Test case need to run successfully");
        // it runs correctly as we gave 1 as expected result and its equal to actual result
    }

    @Test
    public void testAdBookWithDuplicateISBN(){
        Book book1 = new Book("27102004","ADCB","Author2",2006);
        Book book2 = new Book("27102004","ADCE","Author3",2007);
        library.addBook(book1);

        Assertions.assertFalse(library.addBook(book2));// Expecting false because isbn of book is same
        System.out.println("Test Case run successfully because due to duplicate isbn book is not added");
    }

    public void testBorrowBook(){
        Book book = new Book("27102003","XYZW","Author1",2002);
        library.addBook()
    }


}
