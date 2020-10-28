package com.realyoung.linklist;
import booming.leetcode.leetcode_856;

public class Main {

    public static void main(String[] args) {
	    // write your code here
//         testList(new CircleLinkedList<>());

//        testList(new SingleCircleLinkedList<>());
//        testList(new LinkedList<>());
//        testList(new LinkedList2<>());

//        josephus();

//        Queue<Integer> queue = new Queue<>();
//
//        queue.enQueue(11);
//        queue.enQueue(22);
//        queue.enQueue(33);
//        queue.enQueue(44);
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.deQueue());
//        }

//        Deque<Integer> queue = new Deque<>();
//
//        queue.enQueueFront(11);
//        queue.enQueueFront(22);
//        queue.enQueueRear(33);
//        queue.enQueueRear(44);
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.deQueueRear());
//        }

//        testCircleQueue();

//        testCircleDeque();
        leetcode_856 leetcode = new leetcode_856();
        System.out.println(leetcode.scoreOfParentheses("(())(())"));
    }





    static void josephus() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点（指向1）
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }

    }

    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    static void testCircleQueue() {
        CircleQueue<Integer> queue = new CircleQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        for (int i = 0; i < 5; i++){
            queue.deQueue();
        }
        System.out.println(queue);
        for (int i = 15; i < 23; i++){
            queue.enQueue(i);
        }
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    static void testCircleDeque() {
        CircleDeque<Integer> deque = new CircleDeque<Integer>();

        for (int i = 0; i < 10; i++) {
            deque.enQueueFront(i + 1);
            deque.enQueueRear(i + 100);
        }
        System.out.println(deque);

        for (int i = 0; i < 3; i++) {
            deque.deQueueFront();
            deque.deQueueRear();
        }
        System.out.println(deque);
        deque.enQueueFront(11);
        deque.enQueueFront(12);
        System.out.println(deque);

        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
        }
    }
}
