package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int id;
    private boolean checkedOut;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnBook() {
        checkedOut = false;
    }

    @Override
    public String toString() {
        String status = checkedOut ? "Checked Out" : "Available";
        return "ID: " + id + " | Title: " + title + " | Author: " + author + " | Status: " + status;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book(1, "Book1", "Author1"));
        library.addBook(new Book(2, "Book2", "Author2"));
        library.addBook(new Book(3, "Book2", "Author3"));
        library.addBook(new Book(4, "Book2", "Author4"));
        library.addBook(new Book(5, "Book2", "Author5"));
        library.addBook(new Book(6, "Book2", "Author6"));
        library.addBook(new Book(7, "Book2", "Author7"));
        library.addBook(new Book(8, "Book2", "Author8"));
        // Add more books here...

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. List All Books");
            System.out.println("2. Find a Book by ID");
            System.out.println("3. Check Out a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Book> allBooks = library.getAllBooks();
                    for (Book book : allBooks) {
                        System.out.println(book);
                    }
                    break;
                case 2:
                    System.out.print("Enter the book ID: ");
                    int bookId = scanner.nextInt();
                    Book foundBook = library.findBook(bookId);
                    if (foundBook != null) {
                        System.out.println("Book found:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the book ID to check out: ");
                    int checkoutBookId = scanner.nextInt();
                    Book checkoutBook = library.findBook(checkoutBookId);
                    if (checkoutBook != null && !checkoutBook.isCheckedOut()) {
                        checkoutBook.checkOut();
                        System.out.println("Book checked out successfully.");
                    } else {
                        System.out.println("Book not available for checkout.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    Book returnBook = library.findBook(returnBookId);
                    if (returnBook != null && returnBook.isCheckedOut()) {
                        returnBook.returnBook();
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Invalid book ID or book is not checked out.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Library Management System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
