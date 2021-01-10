
public class RentReturn {


	Bookshelf bookshelf = new Bookshelf();

    public RentReturn(){


    }

	public void rentBook(String bookTitle){
		int rentBookIndex;
		rentBookIndex = bookshelf.getIndex(bookTitle);

		bookshelf.setBookStatus(rentBookIndex,"1");
		//User呼び出す
    }

    public void returnBook(){



    }

}
