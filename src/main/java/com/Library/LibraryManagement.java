package com.Library;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args){

        System.out.println("Here are Choices for the work you want to do in Library");
        System.out.println("1 - Adding a book");
        System.out.println("2 - Borrow a book");
        System.out.println("3 - Return a book");
        System.out.println("4 - View available books in library");
        System.out.println("5 - Exit");

        System.out.println("Enter Choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        sc.nextLine();

        Library library = new Library();

        do{
            switch (choice){
                case 1 :
                    System.out.println("Enter the ISBN of book");
                    String isbn = sc.nextLine();
                    System.out.println("Enter the Title of a book");
                    String title = sc.nextLine();
                    System.out.println("Enter the Author's name of a book");
                    String author = sc.nextLine();
                    System.out.println("Enter the Publication year of a book");
                    int publicationYear = sc.nextInt();

                    sc.nextLine();

                    Book book = new Book(isbn,title,author,publicationYear);
                    library.addBook(book);
                    System.out.println("Your book is successfully added");
                    break;

                case 2 :
                    if(library.books.size()==0){
                        System.out.println("Sorry No books available at a time");
                        break;
                    }
                    System.out.println("Enter ISBN of a book you want to borrow");
                    String ISBN = sc.nextLine();

                    Book borrowedBook = library.borrowBook(ISBN);
                    System.out.println("You borrowed book with ISBN : "+borrowedBook.getIsbn());
                    break;

                case 3 :
                    if(library.books.isEmpty()){
                        System.out.println("You can not return a book because there is no book in library so you didn't borrowed any book");
                        break;
                    }
                    System.out.println("Enter ISBN of a book you are returning");
                    String returnISBN = sc.nextLine();
                    for(Book returnBook : library.books){
                        if(returnBook.getIsbn().equals(returnISBN) && !returnBook.isAvailable()){
                            library.returnBook(returnBook);
                            System.out.println("You have successfully returned book with ISBN "+returnBook.getIsbn()+" and title "+returnBook.getTitle());
                            break;
                        }
                    }
                    break;

                case 4 :
                    List<Book> availableBooks = library.getAvailableBooks();
                    if(availableBooks.isEmpty()){
                        System.out.println("There is no book available");
                        break;
                    }
                    System.out.println("Here is the list of books");
                    for(Book avlBook : availableBooks){
                        System.out.println("ISBN : "+avlBook.getIsbn()+", Title : "+avlBook.getTitle()+", Author : "+avlBook.getAuthor()+", Publication Year : "+avlBook.getPublicationYear()+"\n");
                    }
                    break;

                default:
                    System.out.println("You entered wrong choice !!!");
            }

            if(choice != 5) {
                System.out.println("Enter Choice : ");
                choice = sc.nextInt();
                sc.nextLine();
            }

        }while (choice!=5);
    }
}
