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
        Library library = new Library();

        // Adding 10 books with some shared properties
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "Fiction", 1988, 3);
        Book book2 = new Book("Sapiens", "Yuval Noah Harari", "History", 2011, 2);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 1925, 4);
        Book book4 = new Book("1984", "George Orwell", "Dystopian", 1949, 5);
        Book book5 = new Book("Brida", "Paulo Coelho", "Fiction", 1990, 3);
        Book book6 = new Book("Homo Deus", "Yuval Noah Harari", "History", 2016, 2);
        Book book7 = new Book("Animal Farm", "George Orwell", "Dystopian", 1945, 4);
        Book book8 = new Book("Pride and Prejudice", "Jane Austen", "Classic", 1813, 3);
        Book book9 = new Book("To Kill a Mockingbird", "Harper Lee", "Classic", 1960, 5);
        Book book10 = new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951, 3);

        // Adding books to the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);
        library.addBook(book9);
        library.addBook(book10);

        // Borrowing books multiple times
        library.borrowBook("The Alchemist");
        library.borrowBook("The Alchemist");
        library.borrowBook("Sapiens");
        library.borrowBook("1984");
        library.borrowBook("1984");
        library.borrowBook("1984");
        library.borrowBook("Animal Farm");
        library.borrowBook("Animal Farm");
        library.borrowBook("Pride and Prejudice");
        library.borrowBook("To Kill a Mockingbird");
        library.borrowBook("The Catcher in the Rye");
        library.borrowBook("The Catcher in the Rye");

        // Returning a book
        library.returnBook("The Alchemist");
        library.returnBook("1984");

        // Checking the most borrowed book
        Book mostBorrowed = library.getMostBorrowedBook();
        if (mostBorrowed != null) {
            System.out.println("Most borrowed book: " + mostBorrowed.getTitle() + " (" + mostBorrowed.getTotalBorrowed() + " times)");
        }

        // Searching for books by author
        System.out.println("Books by Paulo Coelho: " + library.searchByAuthor("Paulo Coelho"));
        System.out.println("Books by George Orwell: " + library.searchByAuthor("George Orwell"));

        // Searching for books by genre
        System.out.println("Dystopian books: " + library.searchByGenre("Dystopian"));
        System.out.println("Classic books: " + library.searchByGenre("Classic"));

        // Tracking borrowing trends
        library.trackBorrowingTrends();

        // Checking popular genres
        System.out.println("Popular genres: " + library.getPopularGenres());

        // Checking and removing damaged books
        library.removeDamagedBooks();
        System.out.println("Damaged books removed and the library is updated.");
    }
}
