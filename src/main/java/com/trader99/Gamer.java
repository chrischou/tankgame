package com.trader99;

class GamePeople{
//    直接設定一個個靜態的屬性，這邊就NEW自己，且靜態特性是不能被改變
    private static final GamePeople INSTANCE = new GamePeople();
//    把建構方法設定成私有，他這東西變成不能被NEW
    private GamePeople(){}
//    然後給他一個從外部取得的方法
    public  static GamePeople getInstance() {
        return INSTANCE;
    }
}
public class Gamer {
    public static void main(String[] args) {
        System.out.println("SINGLETON");
//        因為主角只有一個，所以他不能被NEW出來，只能直接取來用
        GamePeople worrier = GamePeople.getInstance();
        System.out.println(worrier);
//就算我說主角叫做超人，他出來的記憶體位址，還是同一個，表示沒有辦法被創造新的
        GamePeople superman = GamePeople.getInstance();
        System.out.println(superman);
    }
}
