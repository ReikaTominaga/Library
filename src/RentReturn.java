
public class RentReturn {


	Bookshelf bookshelf = new Bookshelf();

    public RentReturn(){


    }

	public void rentBook(Bookshelf shelf,String bookTitle){
		this.bookshelf = shelf;
		int rentBookIndex;
		rentBookIndex = bookshelf.getIndex(bookTitle);

		bookshelf.setBookStatus(rentBookIndex,"1");
		//User呼び出す
    }

    public void returnBook(){



    }

}
