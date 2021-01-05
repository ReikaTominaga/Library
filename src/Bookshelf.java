import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bookshelf implements Serializable {

	private ArrayList<Book> bookList = new ArrayList<Book>();

	public Bookshelf() {


	}


    public void addBook(String title,String author) {

    bookList.add(new Book(title,author));

    }

    public void delBook() {


    }

    public Map getBookList(){

        Map<String,String> allBooks = new HashMap<>();

        if (bookList.size() == 0){
            System.out.println("現在登録されている本はありません");
        }else{

            for (int i = 0; i < bookList.size(); i++){
            	allBooks.put(bookList.get(i).getTitle(), bookList.get(i).getAuthor());
            }
        }
        return allBooks;
    	}

    public Map getBookStatus() {

        Map<String,String> bookStatus = new HashMap<>();

        if (bookList.size() == 0){
            System.out.println("現在貸出可能な本はありません");
        }else{

            for (int i = 0; i < bookList.size(); i++){
            	bookStatus.put(bookList.get(i).getTitle(), bookList.get(i).getStatus());
            }
        }
        return bookStatus;

    }

    public int getIndex(String bookTitle) {
    	ArrayList<String> bookTitleList = new ArrayList<String>();
    	for (int i = 0; i < bookList.size(); i++){
    		bookTitleList.add(bookList.getTitle().get(i));//※値が格納されていない
    	}
    	return bookTitleList.indexOf(bookTitle);
    }

    public void setBookStatus(int bookIndex,String bookStatus) {
    	bookList.get(bookIndex).setStatus(bookStatus);
    }

    public void outPutFile() {
        try {
            FileOutputStream outFileBook = new FileOutputStream("BookList.dat");
            ObjectOutputStream outObjectBook = new ObjectOutputStream(outFileBook);
            outObjectBook.writeObject(bookList);
            outObjectBook.close();
            outFileBook.close();
        } catch(IOException e) {
        }


    }
}