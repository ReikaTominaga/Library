import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  UserList implements Serializable {

	private ArrayList<User> userList = new ArrayList<User>();
    //登録番号はリストのサイズ+101とする

	public UserList(){


	}

    public Map getUserList() {

        Map<Object,String> allUser = new HashMap<>();

        if (userList.size() == 0){
            System.out.println("現在の利用者登録はありません");
        }else{

            for (int i = 0; i < userList.size(); i++){
                allUser.put(userList.get(i).getUserNum(), userList.get(i).getUserName());
            }
        }
        return allUser;
    	}

    public int addUser(String name) {
        int addnum = 0;
        int listSize = userList.size();

        addnum = listSize + 101;
        userList.add(new User(addnum,name));

    return addnum;
    }

    public void deleteUser(int indexDelete){

    	userList.remove(indexDelete);

    }

}
