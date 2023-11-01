package com.library;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n----- Library Management System -----");
            System.out.println("1. Add a book");
            System.out.println("2. Display available books");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(bookId, bookTitle, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to issue: ");
                    int issueBookId = scanner.nextInt();
                    library.issueBook(issueBookId);
                    break;
                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    Book returnedBook = library.findBook(returnBookId);
                    if (returnedBook == null) {
                        System.out.println("Book with ID " + returnBookId + " not found.");
                    } else {
                        library.returnBook(returnedBook);
                    }
                    break;
                case 5:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

