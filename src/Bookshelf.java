import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bookshelf implements Serializable {

	private ArrayList<Book> bookList = new ArrayList<Book>();

	public Bookshelf() {

	}

	public void addBook(String title, String author) {

		this.bookList.add(new Book(title, author));

	}

	public void delBook(String deleteBookTitle) {

		int deleteIndex = getIndex(deleteBookTitle);
		this.bookList.remove(deleteIndex);

	}

	public Map getBookList() {

		Map<String, String> allBooks = new HashMap<>();

		if (this.bookList.size() == 0) {
			System.out.println("現在登録されている本はありません");
		} else {

			for (int i = 0; i < this.bookList.size(); i++) {
				allBooks.put(this.bookList.get(i).getTitle(), this.bookList.get(i).getAuthor());
			}
		}
		return allBooks;
	}

	public Map getBookStatus() {

		Map<String, String> bookStatus = new HashMap<>();

		if (this.bookList.size() == 0) {
			System.out.println("現在貸出可能な本はありません");
		} else {

			for (int i = 0; i < this.bookList.size(); i++) {
				bookStatus.put(this.bookList.get(i).getTitle(), this.bookList.get(i).getStatus());
			}
		}
		return bookStatus;

	}

	public int getIndex(String bookTitle) {
		ArrayList<String> bookTitleList = new ArrayList<String>();
		for (int i = 0; i < this.bookList.size(); i++) {//違うオブジェクトを参照しているから、リストが空
			bookTitleList.add(this.bookList.get(i).getTitle());
		}
		return bookTitleList.indexOf(bookTitle);
	}

	public void setBookStatus(int bookIndex, String bookStatus) {
		this.bookList.get(bookIndex).setStatus(bookStatus);
	}

	public void outPutFile() {
		try {
			FileOutputStream outFileBook = new FileOutputStream("BookList.dat");
			ObjectOutputStream outObjectBook = new ObjectOutputStream(outFileBook);
			outObjectBook.writeObject(bookList);
			outObjectBook.close();
			outFileBook.close();
		} catch (IOException e) {
		}

	}

	public void inPutFile() {
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
}