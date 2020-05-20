package com.dumbao.singleton;


//饿汉模式
public class HungryMan {

    private static final HungryMan hungryMan = new HungryMan();

    private HungryMan(){

    }

    public static HungryMan getInstance(){
        return hungryMan;
    }

    public static void main(String[] args) {
//        HungryMan hungryMan = HungryMan.getInstance();
//        HungryMan hungryMan1 = HungryMan.getInstance();
//        System.out.println(hungryMan);
//        System.out.println(hungryMan1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                HungryMan hungryMan = HungryMan.getInstance();
                System.out.println(hungryMan);
            }).start();
        }


    }
}
