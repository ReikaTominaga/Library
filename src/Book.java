
public class Book {

    private String title;
    private String author;
    private boolean isAvailable;
    private String genre;
    private String isbn;
    private int id;

    public Book(String title, String author) {
    	this();
        this.title = title;
        this.author = author;
    }

    private Book() {
    	this.setAuthor("");
    	this.setAvailable(true);
    	this.setGenre("");
    	this.setId(-1);
    	this.setIsbn("");
    	this.setTitle("");
    }

    public int rent() {
    	if( this.isAvailable() ) {
    		this.setAvailable( false );
    	}
    	return 0; // 成功したら 0 、失敗したら 1 とか
    }

    public int back() {
    	if( ! this.isAvailable() ) {
    		this.setAvailable( true );
    	}
    	return 0; // 成功したら 0 、失敗したら 1 とか
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return this.isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre( final String genre ) {
		this.genre = genre;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn( final String isbn ) {
		this.isbn = isbn;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
