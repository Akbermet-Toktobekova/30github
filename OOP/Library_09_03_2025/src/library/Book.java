/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author akbermettoktobekova
 */

public class Book {
    private String title;
    private String author;
    private String genre;
    private int year;
    private int copyCount;
    private int totalBorrowed;
    private int damage;

    public Book(String title, String author, String genre, int year, int copyCount) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.copyCount = copyCount;
        this.totalBorrowed = 0;
        this.damage = 0; 
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getCopyCount() {
        return copyCount;
    }

    public int getTotalBorrowed() {
        return totalBorrowed;
    }

    public void borrow() {
        if (copyCount > 0) {
            copyCount--;
            totalBorrowed++;
            damage++; 
        }
    }
    // when the book is borrowed copyCount will decrease, 
    // number of borrowed books will increase and the damage will also increase

    public void returnBook() {
        copyCount++;
    }
    // when the book is returned then the number of copies increases

    public boolean isDamaged() {
        return damage > 20; 
    }
    // is the book was borrowed more than 20 times then the damage > 20, if so - the book is damaged
}
