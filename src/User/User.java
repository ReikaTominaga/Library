package User;
import java.util.ArrayList;

import Book.Book;


public class User extends Human {

	private int id;
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public User(int id, String name) {
        this.setId( id );
        this.setName( name );
//        this.userStatus.add(userNum,bookList);
    }

    public User() {


    }

    public void rentBook( Book book ) {

    	//this.userStatus.replace(userNum,bookList.add(rentTitle));

    }

    public void returnBook( Book book) {

    	//this.userStatus.replace(userNum,bookList.remove(bookList.indexOf(returnTitle)));
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Book> getBookList() {
		return this.bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}


}
