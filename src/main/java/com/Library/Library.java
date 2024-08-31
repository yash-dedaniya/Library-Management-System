package com.Library;

// Import ArrayList class for creating dynamic list of books
import java.util.ArrayList;
// Import List interface for working with collections of books
import java.util.List;

public class Library
{
    private List<Book> books;

    public Library()
    {
        books = new ArrayList<Book>();
    }


}
