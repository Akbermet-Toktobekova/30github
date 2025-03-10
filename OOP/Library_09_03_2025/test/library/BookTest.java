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
public class BookTest {
    private Library lib;
    private Book b1,b2;
            
    @Before
    public void setUp(){
        lib = new Library(); // Initialize library

        // Create books with some intersecting properties
        b1 = new Book("The Alchemist", "Paulo Coelho", "Fiction", 1988, 3);
        b2 = new Book("Sapiens", "Yuval Noah Harari", "History", 2011, 2);
      
        // Add books to the library
        lib.addBook(b1);
        lib.addBook(b2);
    }

   @Test
    public void testBorrow() {
    int initialCopies = b1.getCopyCount();
    int initialBorrowed = b1.getTotalBorrowed();

    b1.borrow(); 

    assertEquals(initialCopies - 1, b1.getCopyCount());  
    assertEquals(initialBorrowed + 1, b1.getTotalBorrowed()); 
    }
    // After borrow copies should decrease and borrow count should increase


    @Test
    public void testReturnBook() {
        int initialCopies = b1.getCopyCount();
        b1.returnBook(); 
        assertEquals(initialCopies + 1, b1.getCopyCount());  
    }
    // After return copycount increases

    @Test
    public void testIsDamaged() {
            assertFalse(b1.isDamaged());  

            // Borrow the book 21 times (damage should increase after 20 borrows)
            for (int i = 0; i < 21; i++) {
                b1.borrow();
            }

            // Now the book should be damaged (damage > 20)
            assertTrue(b1.isDamaged()); 

    }
    // first the book is not damaged(false) as the borrow count is 0, 
    // but after borrowing 21 times it gets damaged and then we check if the condition is true now
    
}
