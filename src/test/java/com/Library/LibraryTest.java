package com.Library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

// Creating LibraryTest class for unit testing of the Library Class
public class LibraryTest
{
    private Library library;

    // Initializes a new Library object before each test with the help of @BeforeEach annotation of JUnit 5
    @BeforeEach
    void setUp(){
        library = new Library();
    }

    // testAddBook is created for to test if a book can be successfully added to the library
    void testAddBook(){
        Book book = new Book("27102003","ABCD","Author1",2008);
        library.addBook(book);

        // testing addBook with false expected result and see that is it give error
        Assertions.assertEquals(0,);
    }

}
