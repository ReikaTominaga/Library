
public class RentManager {


	Bookshelf bookshelf = new Bookshelf();
	User user = new User();

    public RentManager(){


    }

	public void rentBook(Bookshelf shelf,String bookTitle,int userNum){
		this.bookshelf = shelf;
		int rentBookIndex;
		rentBookIndex = bookshelf.getIndex(bookTitle);

//		bookshelf.setBookStatus(rentBookIndex,"1");
		//User呼び出す

    }

}
