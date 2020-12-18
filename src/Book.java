
public class Book {

    private String title;
    private String author;
    private int bookStatus;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookStatus = 0;
    }

    public String getTitle() {
    	return this.title;
    }

    public String getAuthor() {
    	return this.author;
    }


    public int getStatus() {
    	return this.bookStatus;
    }


}
