import Book.Book;
import User.User;

public class ReturnManager {

	public ReturnManager(){


	}

	public void update(User user ,Book book ){

		user.getBookList().remove( book );
		book.back();

    }

}
