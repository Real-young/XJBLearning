package com.realyoung;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Person> list = new ArrayList<>();
//        list.get(0);
        Person person1 = new Person(10,"hello");
        list.add(person1);
        list.add(null);

        Person person2 = new Person(12,"hello1");
        list.add(person2);
        list.add(null);
        Person person3 = new Person(18,"hello2");
        list.add(person3);

        list.add(null);

        System.out.println(list.toString());

        System.out.println(list.indexOf(null));
        list.clear();
        System.gc();
//        System.out.println(list.toString());
    }


    static void test() {

    }
}
