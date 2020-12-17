import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Page {
UserList userlist = new UserList();
Scanner sc1 = new Scanner(System.in);

	public void movePage1(){

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

        switch(Integer.parseInt(operation)){

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

    private void movePage1_1(){

        System.out.println("-----");
        System.out.println("利用者メニュー");
        System.out.println("");
        System.out.println("1.利用者一覧");
        System.out.println("2.利用者を登録する");
        System.out.println("3.利用者を削除する");
        System.out.println("4.もどる");
        System.out.println("5.終了");
        System.out.println("");
        System.out.println("操作を選んでください[1,2,3,4,5]");

        String operation = sc1.nextLine();

        switch(Integer.parseInt(operation)){

            case 1:
                Map<Object,String> displayAllUsers = new HashMap<>();
                displayAllUsers = userlist.getUserList();
                for (Object key : displayAllUsers.keySet()){
                    System.out.println("登録番号:" + key + " " + "利用者名：" + displayAllUsers.get(key));
                }
                this.movePage1_1();
                break;
            case 2:
                System.out.println("登録する利用者名を入力してください");
                String userName = sc1.nextLine();

                int addnum = userlist.addUser(userName);//利用者登録メソッドを呼び出し
                System.out.println("利用者の登録が完了しました！");
                System.out.println(userName + "さんの登録番号は" + addnum + "です");
                this.movePage1_1();
                break;
            case 3:
                System.out.println("削除する利用者名を入力してください");
                String deleteUserName = sc1.nextLine();
                //System.out.println("登録番号を入力してください");
                //int deleteAddNum = sc1.nextInt();

                int resultDel = userlist.deleteUser(deleteUserName);//利用者削除メソッドを呼び出し

                if (resultDel == 0)
                    System.out.println("利用者の削除が完了しました！");
                else
                    System.out.println("利用者が見つかりませんでした。");
                this.movePage1_1();
                break;
            case 4:
                this.movePage1();
                break;
            case 5:
                this.movePage1_4();
                break;
        }
    }

    private void movePage1_2(){

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

        switch(Integer.parseInt(operation)){

            case 1:
                //本リスト、作者リストを表示
                this.movePage1_2();
                break;
            case 2:
                System.out.println("登録する本のタイトルを入力してください");
                String addBookTitle = sc1.nextLine();
                System.out.println("登録する本の著者を入力してください");
                String addBookAuthor = sc1.nextLine();
                //本登録メソッドを呼び出し
                System.out.println("本の登録が完了しました！");
                this.movePage1_2();
                break;
            case 3:
                System.out.println("削除する本のタイトルを入力してください");
                String deleteBookTitle = sc1.nextLine();
                //本削除メソッドを呼び出し
                System.out.println( deleteBookTitle + "の削除が完了しました");
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

    private void movePage1_3(){

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

        switch(Integer.parseInt(operation)){

            case 1:
                //本リスト、作者リスト、ステータスリストを表示
                this.movePage1_3();
                break;
            case 2:
                //本を借りるメソッドを呼び出し
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

    private void movePage1_4(){

    	try {
        FileOutputStream outFileUser = new FileOutputStream("UserList.dat");
        ObjectOutputStream outObject = new ObjectOutputStream(outFileUser);
        outObject.writeObject(userlist);
        outObject.close();
        outFileUser.close();
    } catch(IOException e) {
    }
     System.out.println("ご利用ありがとうございました！");

    }
}
