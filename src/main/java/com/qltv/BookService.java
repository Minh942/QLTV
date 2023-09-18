package com.qltv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    public static void addBook(List<Book> bookList, Scanner input) {
        input.nextLine();
        System.out.print("Enter Title: ");
        String title = input.nextLine();
        System.out.print("Enter Author: ");
        String author = input.nextLine();
        System.out.print("Enter PublicationYear: ");
        int publicationYear = input.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = input.nextInt();

        Book newBook = new Book(title, author, publicationYear, quantity);
        bookList.add(newBook);
        System.out.println("Book added successfully!");
    }

    public static List<Book> searchByTitleOrAuthor(List<Book> bookList, Scanner input) {
        System.out.print("Enter title or author: ");
        String eachKey = input.next();
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(eachKey) || book.getAuthor().equalsIgnoreCase(eachKey)) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    public static void borrowBook(List<Book> bookList, Scanner input) {
        List<Book> matchingBooks = searchByTitleOrAuthor(bookList, input);

        if (matchingBooks.isEmpty()) {
            System.out.println("No matching books found.");
            return;
        }

        System.out.println("Available books for borrowing:");
        displayBooks(matchingBooks);
        System.out.print("Enter the title of the book you want to borrow: ");
        String borrowTitle = input.next();
        Book bookToBorrow = null;
        for (Book book : matchingBooks) {
            if (book.getTitle().equalsIgnoreCase(borrowTitle)) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book not found.");
            return;
        }
        int availableQuantity = bookToBorrow.getQuantity() - bookToBorrow.getBorrowedQuantity();

        if (availableQuantity > 0) {
            System.out.print("Enter the number of copies you want to borrow: ");
            int quantityToBorrow = input.nextInt();

            if (quantityToBorrow > availableQuantity) {
                System.out.println("Sorry, there are only " + availableQuantity + " copies available.");
                return;
            }

            bookToBorrow.borrowQuantity(quantityToBorrow);
            bookToBorrow.decrementQuantity(quantityToBorrow);
            System.out.println("Book(s) borrowed successfully!");
        } else {
            System.out.println("Sorry, the book is out of stock.");
        }
    }

    public static void returnBook(List<Book> bookList, Scanner input) {
        System.out.print("Enter the title of the book you want to return: ");
        String returnTitle = input.next();

        Book bookToReturn = null;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                bookToReturn = book;
                break;
            }
        }

        if (bookToReturn == null) {
            System.out.println("Book not found.");
            return;
        }

        int borrowedQuantity = bookToReturn.getBorrowedQuantity();

        if (borrowedQuantity > 0) {
            System.out.print("Enter the number of copies you want to return: ");
            int quantityToReturn = input.nextInt();

            if (quantityToReturn > 0 && quantityToReturn <= borrowedQuantity) {
                bookToReturn.returnQuantity(quantityToReturn);
                System.out.println("Book(s) returned successfully!");
            } else {
                System.out.println("Invalid quantity to return.");
            }
        } else {
            System.out.println("No copies of this book were borrowed.");
        }
    }



    public static void displayBooks(List<Book> bookList){
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Title                                  Author                     Publication Year     Quantity");
        System.out.println("--------------------------------------------------------------------------------------------------");

        if (bookList.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : bookList) {
                System.out.printf("%-40s %-27s %-20s %-8s\n", book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getQuantity());
            }
        }
    }
}
