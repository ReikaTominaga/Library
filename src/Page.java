import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Page {
	UserList userlist = new UserList();
	Scanner sc1 = new Scanner(System.in);
	Bookshelf bookshelf = new Bookshelf();
	RentManager rentManag = new RentManager();
	ReturnManager returnManag = new ReturnManager();
	User user = new User();

	public Page() {
		File Book = new File("C:\\pleiades\\workspace\\Library\\BookList.dat");
		File User = new File("C:\\pleiades\\workspace\\Library\\UserList.dat");

		if (Book.exists()) {
			bookshelf.load();
		}
		if (User.exists()) {
			userlist.load();
		}

	}

	public void movePage1() {

		System.out.println("-----");
		System.out.println("メインメニュー");
		System.out.println("");
		System.out.println("1.利用者名簿");
		System.out.println("2.本棚");
		System.out.println("3.貸出");
		System.out.println("4.終了");
		System.out.println("");
		System.out.println("操作を選んでください[1,2,3,4]");

		String operation = sc1.nextLine();

		switch (Integer.parseInt(operation)) {

		case 1:
			this.movePage1_1();
			break;
		case 2:
			this.movePage1_2();
			break;
		case 3:
			this.movePage1_3();
			break;
		case 4:
			this.movePage1_4();
			break;
		}
	}

	private void movePage1_1() {

		System.out.println("-----");
		System.out.println("利用者メニュー");
		System.out.println("");
		System.out.println("1.利用者一覧");
		System.out.println("2.利用者を登録する");
		System.out.println("3.利用者を削除する");
		System.out.println("4.借りている本を確認する");
		System.out.println("5.もどる");
		System.out.println("6.終了");
		System.out.println("");
		System.out.println("操作を選んでください[1,2,3,4,5,6]");

		String operation = sc1.nextLine();
		switch (Integer.parseInt(operation)) {

		case 1:
			ArrayList<User> list = userlist.getUserList();

			for(Iterator<User> iterator = list.iterator(); iterator.hasNext(); ) {
				User user = iterator.next();
				System.out.println("登録番号:" + user.getId() + " " + "利用者名：" + user.getName());
			}

			this.movePage1_1();//[後で変更したい]同じページの呼び出しはループで処理する
			break;
		case 2:
			System.out.println("登録する利用者名を入力してください");
			String username = sc1.nextLine();

			int userId = this.userlist.getCumulativeUsers() + this.userlist.getOffsetOfUserId();
			User user = new User( userId, username );

			//利用者登録メソッドを呼び出し
			int addnum = userlist.addUser( user );
			System.out.println("利用者の登録が完了しました！");
			System.out.println(user.getName() + "さんの登録番号は" + addnum + "です");
			this.movePage1_1();
			break;
		case 3:
			System.out.println("削除する利用者名を入力してください");
			String username2 = sc1.nextLine();
			System.out.println("登録番号を入力してください");
			int userId2 = Integer.parseInt( sc1.nextLine() );

			ArrayList<User> deleteAllUsers = userlist.getUserList();

			int deleteIndex = 0;

			if (username2.equals(deleteAllUsers.get(userId2 - userlist.getOffsetOfUserId()).getName())) {
				deleteIndex = userId2 - userlist.getOffsetOfUserId();

				//利用者削除メソッドを呼び出し
				userlist.deleteUser(deleteAllUsers.get(deleteIndex));
				System.out.println("利用者の削除が完了しました");
			} else {
				System.out.println("利用者が見つかりませんでした");
			}
			this.movePage1_1();
			break;
		case 4:
			//借りてる本の状況
			System.out.println("利用状況を確認したい方の、登録番号を入力してください");
			int userNum = Integer.parseInt( sc1.nextLine() );

			User user2 = userlist.getUserList().get( userNum - userlist.getOffsetOfUserId() );

			System.out.println("借りている本の一覧：");
			ArrayList<Book> books = user2.getBookList();

			for(Iterator<Book> iterator = books.iterator(); iterator.hasNext(); ) {
				Book book = iterator.next();
				System.out.println("タイトル：" + book.getTitle());
			}

			this.movePage1_1();
			break;

		case 5:

			this.movePage1();
			break;

		case 6:
			this.movePage1_4();
			break;

		}
	}

	private void movePage1_2() {

		System.out.println("-----");
		System.out.println("本棚メニュー");
		System.out.println("");
		System.out.println("1.本一覧");
		System.out.println("2.本を登録する");
		System.out.println("3.本を削除する");
		System.out.println("4.もどる");
		System.out.println("5.終了");
		System.out.println("");
		System.out.println("操作を選んでください[1,2,3,4,5]");

		String operation = sc1.nextLine();

		switch (Integer.parseInt(operation)) {

		case 1:
			ArrayList<Book> list = bookshelf.getBookList();

			for(Iterator<Book> iterator = list.iterator(); iterator.hasNext(); ) {
				Book book = iterator.next();
				System.out.println("タイトル:" + book.getTitle() + " " + "著者名：" + book.getAuthor());
			}
			this.movePage1_2();
			break;
		case 2:
			System.out.println("登録する本のタイトルを入力してください");
			String addBookTitle = sc1.nextLine();
			System.out.println("登録する本の著者を入力してください");
			String addBookAuthor = sc1.nextLine();

			Book book = new Book( addBookTitle, addBookAuthor );
			//本登録メソッドを呼び出し
			bookshelf.addBook( book );
			System.out.println("本の登録が完了しました！");
			this.movePage1_2();
			break;
		case 3:
			System.out.println("削除する本のタイトルを入力してください");
			String deleteBookTitle = sc1.nextLine();
			//本削除メソッドを呼び出し
			bookshelf.delBook( new Book( deleteBookTitle, "" ) );
			System.out.println(deleteBookTitle + "の削除が完了しました");
			this.movePage1_2();
			break;
		case 4:
			this.movePage1();
			break;

		case 5:
			this.movePage1_4();
			break;
		}
	}

	private void movePage1_3() {

		System.out.println("-----");
		System.out.println("貸出メニュー");
		System.out.println("");
		System.out.println("1.貸出状況");
		System.out.println("2.本を借りる");
		System.out.println("3.本を返却する");
		System.out.println("4.もどる");
		System.out.println("5.終了");
		System.out.println("");
		System.out.println("操作を選んでください[1,2,3,4,5]");

		String operation = sc1.nextLine();

		switch (Integer.parseInt(operation)) {

		case 1:
			//本リスト、ステータスリストを表示
			ArrayList<Book> list = bookshelf.getBookList();

			for(Iterator<Book> iterator = list.iterator(); iterator.hasNext(); ) {
				Book book = iterator.next();
				if( book.isAvailable() ) {
					System.out.println("タイトル：" + book.getTitle() + ", 貸出状況：貸出可");
				}
				else {
					System.out.println("タイトル：" + book.getTitle() + ", 貸出状況：貸出中");
				}
			}

			this.movePage1_3();
			break;
		case 2:
			System.out.println("借りる方の登録番号を入力してください");
			int userNum = Integer.parseInt( sc1.nextLine() );
			System.out.println("借りたい本のタイトルを入力してください");
			String rentTitle = sc1.nextLine();

			User user = this.userlist.getUser( userNum );
			Book book = this.bookshelf.getBookByTitle( rentTitle );

			// TODO: userlistの中の該当ユーザの、借りている本に Book を追加する。
			user.getBookList().add( book ); // 参照渡しならこれでおｋ

			// TODO: bookshelfの中の該当する本で、「貸出」をする（ rent() メソッド）
			book.rent(); // 参照わたしだったらこれでおｋ

			/*
			Map<String, String> rentBookList = new HashMap<>();
			rentBookList = bookshelf.getBookStatus();

			if (rentBookList.containsKey(rentTitle)) {
				if (rentBookList.get(rentTitle) == "0") {
					//本を借りるメソッドを呼び出し
					rentManag.rentBook(bookshelf,rentTitle,userNum);
					System.out.println(rentTitle + "の貸出しが完了しました。");
				} else {
					System.out.println("指定されたタイトルは現在貸出中です。");
				}

			} else {
				System.out.println("指定されたタイトルが見つかりません。");
			}
			*/

			this.movePage1_3();
			break;
		case 3:
			//本を返すメソッドを呼び出し
			this.movePage1_3();
			break;
		case 4:
			this.movePage1();
			break;
		case 5:
			this.movePage1_4();
			break;
		}
	}

	private void movePage1_4() {

		userlist.save();
		bookshelf.save();

		System.out.println("ご利用ありがとうございました！");

	}
}
