/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author akbermettoktobekova
 */

import java.util.*;

public class Library {
    private List<Book> books;
    private int totalBorrowedBooks;
    private int damagedBooksCount;
    private Map<String, Integer> borrowedBooks; // Tracks borrowed counts for each book
    private Map<String, Integer> genreStats; // Tracks borrowing statistics for genres

    public Library() {
        this.books = new ArrayList<>();
        this.totalBorrowedBooks = 0;
        this.damagedBooksCount = 0;
        this.borrowedBooks = new HashMap<>();
        this.genreStats = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    // we simple add the given book to the books list
   

    public void removeDamagedBooks() {
        List<Book> goodBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isDamaged()) {
                goodBooks.add(book);
            } else {
                damagedBooksCount++; 
            }
        }
        books = goodBooks; 
    }
    // since we are iterating through books in a list, we should simple remove the book as it will cause index error
    // therefore we create a new List of "goodBooks" and assign it's results to the initial list
    

    public void borrowBook(String title) {
        // if the count of copies is > 0 then we borrow a book with the given title
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getCopyCount() > 0) {
                book.borrow();
                totalBorrowedBooks++;
                
                        // Filling in the info for the stats
                
                // if there is no such title given we put a (title, 0) pair,
                // if there is such title, then we put the value incremented by 1
                borrowedBooks.put(title, borrowedBooks.getOrDefault(title, 0) + 1);

                // same process for the genre stats
                genreStats.put(book.getGenre(), genreStats.getOrDefault(book.getGenre(), 0) + 1);

                return; // Stop after borrowing the first available copy
            }
        }
        // If no book was borrowed, we can log a message
        System.out.println("The book '" + title + "' is not available for borrowing.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.returnBook();
                return;
            }
        }
    }
    // to return a book we call the returnBook method from the Book class

    public Book getMostBorrowedBook() {
        if (books.isEmpty()) {
            return null;
        }
        Book maxBook = books.get(0);
        for (Book book : books) {
            if (book.getTotalBorrowed() > maxBook.getTotalBorrowed()) {
                maxBook = book;
            }
        }
        return maxBook;
    }
    // if the books list is not empty, we create a maxBook and 
    // compare it with the current book's borrow number and do the max search

    public List<Book> searchByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }
    // we create authorBooks to store the books, where the current book's author is the same with the given author

    public List<Book> searchByGenre(String genre) {
        List<Book> genreBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                genreBooks.add(book);
            }
        }
        return genreBooks;
    }
    // same as author, but for genre

    
    public void trackBorrowingTrends() {
        System.out.println("Borrowing Trends:");
        for (Map.Entry<String, Integer> entry : borrowedBooks.entrySet()) {
            System.out.println("Book: " + entry.getKey() + " | Borrowed: " + entry.getValue() + " times");
        }
    }
    // Tracking the borrowing trends - frequency of borrowing for each book

    
    public List<String> getPopularGenres() {
        List<String> popularGenres = new ArrayList<>();
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreStats.entrySet());
        genreList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort in descending order

        for (Map.Entry<String, Integer> entry : genreList) {
            popularGenres.add(entry.getKey());
        }

        return popularGenres;
    }
    // We create a list of genres - popularGenres, 
    // then sort the genreStats map entries in descending order based on their values, 
    // and then adds the genre names (keys) to the popularGenres list before returning it.
}
