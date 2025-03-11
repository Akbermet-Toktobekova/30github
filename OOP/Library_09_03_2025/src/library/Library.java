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
        books.add(book); // Add the given book to the books list
    }
    

    public void removeDamagedBooks() {
        List<Book> goodBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getDamage() < 20) {
                goodBooks.add(book); // Keep the book if it is not damaged
            } else {
                damagedBooksCount++; // Increment damaged books count
            }
        }
        books = goodBooks; // Update the books list with only good books
    }

    public void borrowBook(String title) {
        // If the count of copies is > 0, borrow the book with the given title
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getCopyCount() > 0) {
                book.setCopyCount(book.getCopyCount()-1); // Decrease available copies
                book.setDamage(book.getDamage()+1); // Increment the damage count

                // Filling in statistics for the current book
                borrowedBooks.put(title, borrowedBooks.getOrDefault(title, 0) + 1);
                genreStats.put(book.getGenre(), genreStats.getOrDefault(book.getGenre(), 0) + 1);

                totalBorrowedBooks++; // Increment total borrowed books in the library

                return; // Stop after borrowing the first available copy
            }
        }
        // If no book was borrowed, log the message
        System.out.println("The book '" + title + "' is not available for borrowing.");
    }

    public void returnBook(String title) {
        // Return the borrowed book by increasing the copy count
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setCopyCount(book.getCopyCount() + 1);
                return;
            }
        }
    }

    public Book getMostBorrowedBook() {
        if (books.isEmpty()) {
            return null; // Return null if no books are available
        }
        Book maxBook = books.get(0);
        for (Book book : books) {
            if (book.getDamage() > maxBook.getDamage()) {
                maxBook = book; // Update maxBook if the current book has more damage (more borrowed)
            }
        }
        return maxBook; // Return the book with the highest borrow count
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                authorBooks.add(book); // Add books by the given author
            }
        }
        return authorBooks; // Return the list of books by the author
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> genreBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                genreBooks.add(book); // Add books of the given genre
            }
        }
        return genreBooks; // Return the list of books in the specified genre
    }

    public void trackBorrowingTrends() {
        System.out.println("Borrowing Trends:");
        for (Map.Entry<String, Integer> entry : borrowedBooks.entrySet()) {
            System.out.println("Book: " + entry.getKey() + " | Borrowed: " + entry.getValue() + " times");
        }
    }

    public List<String> getPopularGenres() {
        List<String> popularGenres = new ArrayList<>();
        List<Map.Entry<String, Integer>> genreList = new ArrayList<>(genreStats.entrySet());
        genreList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // Sort genres in descending order based on borrow count

        for (Map.Entry<String, Integer> entry : genreList) {
            popularGenres.add(entry.getKey()); // Add genre names to the list of popular genres
        }

        return popularGenres; // Return the sorted list of popular genres
    }
// We create a list of genres - popularGenres, 
// then sort the genreStats map entries in descending order based on their values, 
// and then adds the genre names (keys) to the popularGenres list before returning it.

    public int getTotalBorrowedBooks() {
        return totalBorrowedBooks; // Return the total count of borrowed books in the library
    }
    
    public int getDamagedBooksCount() {
        return damagedBooksCount; // Return the total count of damaged books in the library
    }
    
}
