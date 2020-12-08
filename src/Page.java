import java.util.Scanner;

public class Page {
UserList userlist = new UserList();

	void page1(){

        System.out.println("-----");
        System.out.println("メインメニュー");
        System.out.println("");
        System.out.println("1.利用者名簿");
        System.out.println("2.本棚");
        System.out.println("3.貸出");
        System.out.println("4.終了");
        System.out.println("");
        System.out.println("操作を選んでください[1,2,3,4]");

        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();

        switch(Integer.parseInt(input)){

            case 1:
                page1_1();
                break;
            case 2:
                page1_2();
                break;
            case 3:
                page1_3();
                break;
            case 4:
                page1_4();
                break;
        }
    }

    void page1_1(){

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

        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();

        switch(Integer.parseInt(input)){

            case 1:
                userlist.getList();
                //利用者リストを表示
                page1_1();
                break;
            case 2:
                System.out.println("登録する利用者名を入力してください");
                Scanner sc2 = new Scanner(System.in);
                String input2 = sc2.nextLine();

                int addnum = userlist.addUser(input2);//利用者登録メソッドを呼び出し
                System.out.println("利用者の登録が完了しました！");
                System.out.println(input2 + "さんの登録番号は" + addnum + "です");
                page1_1();
                break;
            case 3:
                System.out.println("削除する利用者名を入力してください");
                Scanner sc3 = new Scanner(System.in);
                String input3 = sc3.nextLine();
                System.out.println("登録番号を入力してください");
                Scanner sc4 = new Scanner(System.in);
                int input4 = sc4.nextInt();

                int resultDel = userlist.delUser(input3,input4);//利用者削除メソッドを呼び出し

                if (resultDel == 0)
                    System.out.println("利用者の削除が完了しました！");
                else
                    System.out.println("利用者が見つかりませんでした。");
                page1_1();
                break;
            case 4:
                page1();
                break;
            case 5:
                page1_4();
                break;
        }
    }

    void page1_2(){

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

        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();

        switch(Integer.parseInt(input)){

            case 1:
                //本リスト、作者リストを表示
                page1_2();
                break;
            case 2:
                System.out.println("登録する本のタイトルを入力してください");
                Scanner sc2 = new Scanner(System.in);
                String input2 = sc2.nextLine();
                System.out.println("登録する本の著者を入力してください");
                Scanner sc3 = new Scanner(System.in);
                String input3 = sc3.nextLine();
                //本登録メソッドを呼び出し
                System.out.println("本の登録が完了しました！");
                page1_2();
                break;
            case 3:
                System.out.println("削除する本のタイトルを入力してください");
                Scanner sc4 = new Scanner(System.in);
                String input4 = sc4.nextLine();
                //本削除メソッドを呼び出し
                System.out.println("本の削除が完了しました！");
                page1_2();
                break;
            case 4:
                page1();
                break;
            case 5:
                page1_4();
                break;
        }
    }

    void page1_3(){

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

        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine();

        switch(Integer.parseInt(input)){

            case 1:
                //本リスト、作者リスト、ステータスリストを表示
                page1_3();
                break;
            case 2:
                //本を借りるメソッドを呼び出し
                page1_3();
                break;
            case 3:
                //本を返すメソッドを呼び出し
                page1_3();
                break;
            case 4:
                page1();
                break;
            case 5:
                page1_4();
                break;
        }
    }

    void page1_4(){

        System.out.println("ご利用ありがとうございました！");
    }


}
