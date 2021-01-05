
public class RentReturn {


	Bookshelf bookshelf = new Bookshelf();

    public RentReturn(){


    }

	public void rentBook(String bookTitle){
		int rentBookIndex;
		rentBookIndex = bookshelf.getIndex(bookTitle);
		if(rentBookIndex==-1) {
			System.out.println("指定されたタイトルが見つかりません。");
		}else {
			bookshelf.setBookStatus(rentBookIndex,"1");
		}
    }

    public void returnBook(){



    }

}
