package com.qltv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    public static void saveLibrary(List<Book> bookList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : bookList) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPublicationYear() + "," + book.getQuantity());
                writer.newLine();
            }
            System.out.println("Library data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving library data: " + e.getMessage());
        }
    }
    public static List<Book> loadLibrary(String filePath) {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int publicationYear = Integer.parseInt(parts[2].trim());
                    int quantity = Integer.parseInt(parts[3].trim());
                    Book book = new Book(title, author, publicationYear, quantity);
                    bookList.add(book);
                }
            }
            System.out.println("Library data loaded successfully!");
        } catch (IOException e) {
            System.err.println("Error loading library data: " + e.getMessage());
        }
        return bookList;
    }
}
