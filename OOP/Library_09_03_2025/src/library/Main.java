/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author akbermettoktobekova
 */

public class Main {

    public static void main(String[] args) {
        // Create a new library
        Library library = new Library();

        // Create some books and add them to the library
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, 5);
        Book book2 = new Book("1984", "George Orwell", "Dystopia", 1949, 3);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Borrow some books
        System.out.println("Borrowing 'The Great Gatsby'...");
        library.borrowBook("The Great Gatsby");
        System.out.println("Copies left of 'The Great Gatsby': " + book1.getCopyCount());

        System.out.println("Borrowing '1984'...");
        library.borrowBook("1984");
        System.out.println("Copies left of '1984': " + book2.getCopyCount());

        // Try borrowing a book that's not available
        System.out.println("Trying to borrow a book that's not in the library...");
        library.borrowBook("Non-existent Book");

        // Return a book
        System.out.println("Returning 'The Great Gatsby'...");
        library.returnBook("The Great Gatsby");
        System.out.println("Copies left of 'The Great Gatsby': " + book1.getCopyCount());

        // Track borrowing trends
        library.trackBorrowingTrends();

        // Get the most borrowed book
        Book mostBorrowed = library.getMostBorrowedBook();
        if (mostBorrowed != null) {
            System.out.println("Most Borrowed Book: " + mostBorrowed.getTitle());
        } else {
            System.out.println("No books have been borrowed yet.");
        }

        // Search by author
        System.out.println("Searching books by George Orwell...");
        library.searchByAuthor("George Orwell").forEach(book -> 
            System.out.println("Found book: " + book.getTitle())
        );

        // Search by genre
        System.out.println("Searching books in the 'Fiction' genre...");
        library.searchByGenre("Fiction").forEach(book -> 
            System.out.println("Found book: " + book.getTitle())
        );

        // Get popular genres
        System.out.println("Popular Genres:");
        library.getPopularGenres().forEach(genre -> 
            System.out.println(genre)
        );

        // Remove damaged books (let's assume "The Great Gatsby" is damaged)
        book1.setDamage(25);
        library.removeDamagedBooks();
        System.out.println("Remaining books after removing damaged ones:");
        library.searchByGenre("Fiction").forEach(book -> 
            System.out.println("Remaining book: " + book.getTitle())
        );
    }
}
