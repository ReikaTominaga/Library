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


 }
