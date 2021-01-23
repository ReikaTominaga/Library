import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable {

	private ArrayList<User> userList = new ArrayList<User>();
	private int cumulativeUsers = 0;
	private final int offsetOfUserId = 100;

	public UserList() {

	}

	/*
	 * ユーザを追加します。
	 */
	public int addUser( User user) {
		this.userList.add( user);
		this.incCumulativeUsers();

		return user.getId();
	}

	public void incCumulativeUsers() {

		this.cumulativeUsers++;
	}


	public void deleteUser( User user ) {

		this.userList.remove( user.getId() - this.offsetOfUserId );
	}

	/**
	 * ユーザIDから該当するユーザオブジェクトを返却します。
	 *
	 * @param id 取得したいユーザID
	 * @return ユーザ
	 */
	public User getUser( int id ) {

		return this.userList.get( id - this.offsetOfUserId );
	}

	public void save() {
		try {
			FileOutputStream outFileUser = new FileOutputStream("UserList.dat");
			ObjectOutputStream outObjectUser = new ObjectOutputStream(outFileUser);
			outObjectUser.writeObject(this.userList);
			outObjectUser.close();
			outFileUser.close();
		} catch (IOException e) {
		}
	}

	public void load() {//うまくいってない
		try {
			FileInputStream inFile = new FileInputStream("UserList.dat");
			ObjectInputStream inObject = new ObjectInputStream(inFile);
			UserList userList = (UserList) inObject.readObject();
			inObject.close();
			inFile.close();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}

	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public int getCumulativeUsers() {
		return cumulativeUsers;
	}

	public void setCumulativeUsers(int cumulativeUsers) {
		this.cumulativeUsers = cumulativeUsers;
	}

	public int getOffsetOfUserId() {
		return offsetOfUserId;
	}



}
