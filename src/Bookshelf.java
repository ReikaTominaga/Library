import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Bookshelf implements Serializable {

	private ArrayList<Book> bookList = new ArrayList<Book>();
	private String ID; //A-1,A-2...など
	private String color;
	private int maxBookCapacity;
	private int withstandLoad;//耐荷重

	public Bookshelf() {

	}

	public void addBook(Book book) {

		this.bookList.add(book);

	}

	public void delBook(Book book) {

		int deleteIndex = this.getIndex(book.getTitle());
		this.bookList.remove(deleteIndex);
	}

	// もっといいやりかたあるよ
	public int getIndex(String bookTitle) {
		ArrayList<String> bookTitleList = new ArrayList<String>();
		for (int i = 0; i < this.bookList.size(); i++) {
			bookTitleList.add(this.bookList.get(i).getTitle());
		}
		return bookTitleList.indexOf(bookTitle);
	}

	/**
	 *
	 * @param title
	 * @return
	 */
	public Book getBookByTitle(String title) {
		ArrayList<String> bookTitleList = new ArrayList<String>();
		for (int i = 0; i < this.bookList.size(); i++) {
			bookTitleList.add(this.bookList.get(i).getTitle());
		}
		return this.bookList.get( bookTitleList.indexOf(title) );
	}



	public void save() {
		try {
			FileOutputStream outFileBook = new FileOutputStream("BookList.dat");
			ObjectOutputStream outObjectBook = new ObjectOutputStream(outFileBook);
			outObjectBook.writeObject(bookList);
			outObjectBook.close();
			outFileBook.close();
		} catch (IOException e) {
		}

	}

	public void load() {//うまくいってない
		try {
			FileInputStream inFile = new FileInputStream("BookList.dat");
			ObjectInputStream inObject = new ObjectInputStream(inFile);
			Bookshelf bookList = (Bookshelf) inObject.readObject();
			inObject.close();
			inFile.close();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

	}

	public ArrayList<Book> getBookList() {
		return this.bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxBookCapacity() {
		return this.maxBookCapacity;
	}

	public void setMaxBookCapacity(int maxBookCapacity) {
		this.maxBookCapacity = maxBookCapacity;
	}

	public int getWithstandLoad() {
		return this.withstandLoad;
	}

	public void setWithstandLoad(int withstandLoad) {
		this.withstandLoad = withstandLoad;
	}


}