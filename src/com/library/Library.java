package com.library;

import java.util.ArrayList;

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("Books in the library:");
        System.out.println("----------------------");
        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getBookTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("----------------------");
        }
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void issueBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        books.remove(book);
        System.out.println("Book with ID " + bookId + " has been issued.");
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Book with ID " + book.getBookId() + " has been returned.");
    }
}

