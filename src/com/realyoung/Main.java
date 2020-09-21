package com.realyoung;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Person> list = new ArrayList<>();
//        list.get(0);
        Person person1 = new Person(10,"hello");
        list.add(person1);

        Person person2 = new Person(12,"hello1");
        list.add(person2);

        Person person3 = new Person(18,"hello2");
        list.add(person3);

        System.out.println(list.toString());

        list.clear();
        System.gc();
//        System.out.println(list.toString());
    }


    static void test() {

    }
}
