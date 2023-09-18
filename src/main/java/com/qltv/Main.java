package com.qltv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        String filePath = "C:\\java\\QLTV\\src\\main\\resources\\Library";
        LibraryService libraryService;
        bookList = LibraryService.loadLibrary(filePath);
        Scanner input = new Scanner(System.in);
        int select;
        do {
            System.out.println();
            System.out.println("Select feature: ");
            System.out.println("1. Add a book.");
            System.out.println("2. Find Book.");
            System.out.println("3. Borrow book.");
            System.out.println("4. Give book back.");
            System.out.println("5. Display Book.");
            System.out.println("6. Save Library.");
            System.out.println("7. Exit");
            System.out.print("Your Choice: ");
            select = input.nextInt();

            switch (select) {
                case 1:
                    BookService.addBook(bookList, input);
                    BookService.displayBooks(bookList);
                    break;
                case 2:
                    List<Book> matchingBooks = BookService.searchByTitleOrAuthor(bookList, input);
                    if (matchingBooks.isEmpty()) {
                        System.out.println("No matching books found.");
                    } else {
                        System.out.println("Matching Books:");
                        BookService.displayBooks(matchingBooks);
                    }
                    break;
                case 3:
                    BookService.borrowBook(bookList, input);
                    break;
                case 4:
                    BookService.returnBook(bookList, input);
                    break;
                case 5:
                    BookService.displayBooks(bookList);
                    break;
                case 6:
                    LibraryService.saveLibrary(bookList, filePath);
                    break;
                case 7:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (select != 7);
    }
}
