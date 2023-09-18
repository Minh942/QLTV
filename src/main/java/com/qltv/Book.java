package com.qltv;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int quantity;
    private int borrowedQuantity;
    public Book(String title, String author, int publicationYear, int quantity) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.quantity = quantity;
        this.borrowedQuantity = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBorrowedQuantity() {
        return borrowedQuantity;
    }

    public void borrowQuantity(int amount) {
        if (amount > 0 && amount <= (quantity - borrowedQuantity)) {
            borrowedQuantity += amount;
        }
    }
    public void returnQuantity(int amount) {
        if (amount > 0 && amount <= borrowedQuantity) {
            borrowedQuantity -= amount;
            quantity += amount;
        }
    }
    public void decrementQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            System.out.println("Not enough copies available to borrow.");
        }
    }
}
