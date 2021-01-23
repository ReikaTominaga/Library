import Book.Book;
import User.User;

public class RentManager {

    public RentManager(){


    }

	public void update(User user ,Book book){

		user.getBookList().add( book );
		book.rent();

    }

}
