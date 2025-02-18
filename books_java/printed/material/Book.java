package printed.material;

public class Book {
    public static final String defaultAuthor = "John Steinback";
    public static final String defaultTitle = "Of Mice and Men";
    public static final int defaultPageCount = 107;

    private String author;
    private String title;
    protected int pageCount;

    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public Book(){
        this(defaultAuthor, defaultTitle, defaultPageCount);
    }

    public Book(String author, String title, int pageCount){
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }

    private void checkInitData(String author, String title, int pageCount){
        if (author.length()<2 || title.length()<4 || pageCount<=0){
            throw new IllegalArgumentException();
        }
    }

    protected void initBook(String author, String title, int pageCount){
        this.author = author;
        this.title = title;
        this.pageCount = pageCount;
    }
}
