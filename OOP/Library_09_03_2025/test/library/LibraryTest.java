/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package library;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author akbermettoktobekova
 */

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;

    @Before
    public void setUp() {
        // Creating a new library and some books before each test
        library = new Library();
        book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, 5);
        book2 = new Book("1984", "George Orwell", "Dystopia", 1949, 3);

        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 2);
        library.addBook(book3);

        List<Book> books = library.searchByGenre("Fiction");
        assertEquals(2, books.size()); // The library now has 2 fiction books
    }

    @Test
    public void testRemoveDamagedBooks() {
        book1.setDamage(25); // Simulate damage
        library.removeDamagedBooks();

        List<Book> books = library.searchByGenre("Fiction");
        assertEquals(0, books.size()); // Book1 should be removed
    }

    @Test
    public void testBorrowBook() {
        library.borrowBook("The Great Gatsby");
        assertEquals(4, book1.getCopyCount()); // One copy should be borrowed, remaining 4
        assertEquals(1, library.getTotalBorrowedBooks()); // Total borrowed books should be 1
        
        library.borrowBook("Unknown Book");
        assertEquals(4, book1.getCopyCount());
    }


    @Test
    public void testReturnBook() {
        library.borrowBook("The Great Gatsby");
        library.returnBook("The Great Gatsby");
        assertEquals(5, book1.getCopyCount()); // Return should increase the copy count back to 5
    }

    @Test
    public void testGetMostBorrowedBook() {
        library.borrowBook("The Great Gatsby");
        library.borrowBook("The Great Gatsby");
        library.borrowBook("1984");

        Book mostBorrowed = library.getMostBorrowedBook();
        assertEquals("The Great Gatsby", mostBorrowed.getTitle()); // "The Great Gatsby" should be the most borrowed
        
        library = new Library(); // Reset the library instance
        assertNull(library.getMostBorrowedBook()); // Expect null since there are no books
    }

    @Test
    public void testSearchByAuthor() {
        List<Book> booksByAuthor = library.searchByAuthor("George Orwell");
        assertEquals(1, booksByAuthor.size()); // Should return 1 book by George Orwell
    }

    @Test
    public void testSearchByGenre() {
        List<Book> booksByGenre = library.searchByGenre("Fiction");
        assertEquals(1, booksByGenre.size()); // Should return 1 book in the "Fiction" genre
    }

    @Test
    public void testTrackBorrowingTrends() {
        library.borrowBook("The Great Gatsby");
        library.borrowBook("1984");

        library.trackBorrowingTrends(); // Should print the borrowing statistics to the console
    }

    @Test
    public void testGetPopularGenres() {
        library.borrowBook("The Great Gatsby");
        library.borrowBook("The Great Gatsby");
        library.borrowBook("1984");

        List<String> popularGenres = library.getPopularGenres();
        assertEquals("Fiction", popularGenres.get(0)); // the most popular book should be the first one in the list
        assertTrue(popularGenres.contains("Dystopia"));
    }
    
    @Test
    public void testGetTotalBorrowedBooks() {
        assertEquals(0, library.getTotalBorrowedBooks()); // Initially 0

        library.borrowBook("The Great Gatsby");
        assertEquals(1, library.getTotalBorrowedBooks()); // After borrowing one book

        library.borrowBook("1984");
        library.borrowBook("1984");
        assertEquals(3, library.getTotalBorrowedBooks()); // After borrowing multiple books
    }

    @Test
    public void testGetDamagedBooksCount() {
        assertEquals(0, library.getDamagedBooksCount()); // Initially 0

        book1.setDamage(25);
        book2.setDamage(20);

        library.removeDamagedBooks(); // Remove books with damage ≥ 20
        assertEquals(2, library.getDamagedBooksCount()); // One book should be considered damaged and removed
    }
}
