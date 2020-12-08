import java.io.Serializable;

public class  UserList implements Serializable {

	private String[] userList = new String[100];
    //登録番号は添字の＋１+１００とする

    void getList() {
    	for (int i = 0 ; i < 100 ; i++) {
            if (userList[0] == null ) {
            	System.out.println("現在の利用者登録はありません");
            	break;
           }else if (userList[i] != null){
            	System.out.println("登録番号：" + (i+101) + "  " + "利用者名：" + userList[i]);
            }

            }
    	}

    int addUser(String name) {
        int addnum = 0;
        for(int i = 0 ; i < 100 ; i++){
            if (userList[i] == null) {
                userList[i] = name;
                addnum = i+101;
                break;
            }
        }

    return addnum;
    }

    int delUser(String name,int num){
        int index = num - 101;
        if (userList[index].equals(name)) {
            userList[index] = null;
            return 0;
        }else {
            return 1;
        }



    }

}
