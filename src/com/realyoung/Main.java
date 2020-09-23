package com.realyoung;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        List<Integer> list = new LinkedList<>();

        list.add(20);
        list.add(30);
        list.add(0,40);

        // 40 20 30
        System.out.println(list.toString());

        list.add(list.size(),80);

        // 40 20 30 80
        System.out.println(list.toString());

        list.remove(1);

        // 40 30 80
        System.out.println(list.toString());


    }


    static void test() {
        //        ArrayList<Person> list = new ArrayList<>();
////        list.get(0);
//        Person person1 = new Person(10,"hello");
//        list.add(person1);
//        list.add(null);
//
//        Person person2 = new Person(12,"hello1");
//        list.add(person2);
//        list.add(null);
//        Person person3 = new Person(18,"hello2");
//        list.add(person3);
//
//        list.add(null);
//
//        System.out.println(list.toString());
//
//        System.out.println(list.indexOf(null));
//        list.clear();
//        System.gc();
//        System.out.println(list.toString());
    }
}
