import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserList implements Serializable {

	private ArrayList<User> userList = new ArrayList<User>();
	private int addnumCount = 100;

	public UserList() {

	}

	public Map getUserList() {

		Map<Object, String> allUser = new HashMap<>();

		if (this.userList.size() == 0) {
			System.out.println("現在の利用者登録はありません");
		} else {

			for (int i = 0; i < this.userList.size(); i++) {
				allUser.put(this.userList.get(i).getUserNum(), this.userList.get(i).getUserName());
			}
		}
		return allUser;
	}

	public int addUser(String name) {
		this.addnumCount += 1;
		int listSize = this.userList.size();

		this.userList.add(new User(this.addnumCount, name));

		return this.addnumCount;
	}

	public void deleteUser(int indexDelete) {

		this.userList.remove(indexDelete);

	}

	public void outPutFile() {
		try {
			FileOutputStream outFileUser = new FileOutputStream("UserList.dat");
			ObjectOutputStream outObjectUser = new ObjectOutputStream(outFileUser);
			outObjectUser.writeObject(this.userList);
			outObjectUser.close();
			outFileUser.close();
		} catch (IOException e) {
		}
	}

	public void inPutFile() {
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

}
