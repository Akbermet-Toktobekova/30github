package printed.material.specific;

import java.security.Principal;
import printed.material.Book;
import printed.material.CoverType;

public class PrintedBook extends Book {
    protected CoverType coverType;

    public PrintedBook(String author, String title, int pageCount, CoverType coverType){
        super(author, title, pageCount +6);
        this.coverType = coverType;
    }
    
    // public PrintedBook(Book book){
    //     this(book.getAuthor(), book.getTitle(), book.getPageCount(),CoverType)
    // }

    @Override
    public int getPrice(){
        if(coverType == coverType.HARDCOVER){
            return super.getPrice()*3;
        } else {
            return super.getPrice()*2;
        }

    }

    public static PrintedBook decode(String bookData) {
        return null;
    }

    @Override
    public String toString(){
        return super.toString() + "(" + coverType + ")";
    }
}
