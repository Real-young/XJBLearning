package com.realyoung;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList list = new ArrayList();
//        list.get(0);
        list.add(123);
        list.add(1232);
        list.add(22);
        list.add(88);
        list.add(777);
        list.add(5567);
        System.out.println(list.toString());

        list.remove(3);
        System.out.println(list.toString());
    }
}
