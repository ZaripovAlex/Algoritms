package org.example;

public class Main {
//    public class sList {
//        private Node Head;
//
//        private class Node {
//            private int value;
//            private Node next;
//        }
//
//        void push(int value) {
//            Node node = new Node();
//            node.value = value;
//            node.next = Head;
//            Head = node;
//        }
//
//        Integer pop() {
//            if (Head != null) {
//                Integer value = Head.value;
//                Head = Head.next;
//                return value;
//            }
//            return null;
//        }
//
//        void print() {
//            Node current = Head;
//            while (current != null) {
//                System.out.println(current.value);
//                current = current.next;
//            }
//        }
//
//        void pushBack(int value) {
//            Node node = new Node();
//            node.value = value;
//
//            Node current = Head;
//            if (current != null) {
//                while (current.next != null) {
//                    current = current.next;
//                }
//                current.next = node;
//            } else {
//                Head = node;
//            }
//        }
//
//        Node find(int value) {
//            Node current = Head;
//            while (current != null) {
//                if (current.value == value) {
//                    return current;
//                }
//                current = current.next;
//            }
//            return null;
//        }
//
//    }}





    public static class dList{
        private Node Head;
        private Node Tail;
        private class Node{
            private int value;
            private Node next;
            private Node prev;
        }

        void pushFront(int value){
            Node node = new Node();
            node.value = value;
            if(Head != null) {
                Head.prev = node;
                node.next = Head;
            }else{
                Tail = node;
            }

            Head = node;
        }

        Integer popFront(){
            if(Head != null) {
                Integer value = Head.value;
                if(Head.next != null) {
                    Head = Head.next;
                    Head.prev = null;
                }else{
                    Head = null;
                    Tail = null;
                }
                return value;
            }
            return null;
        }

        void print(){
            Node current = Head;
            while (current != null){
                System.out.printf("%d ", current.value);
                current = current.next;
            }
        }

        void pushBack(int value){
            Node node = new Node();
            node.value = value;

            if(Tail != null){
                Tail.next = node;
                node.prev = Tail;
            }else{
                Head = node;
            }

            Tail = node;
        }

        Node find(int value){
            Node current = Head;
            while (current != null){
                if(current.value == value){
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        Node revFind(int value){
            Node current = Tail;
            while (current != null){
                if(current.value == value){
                    return current;
                }
                current = current.prev;
            }
            return null;
        }
        //----------------------------------------------------------------------------------------------------

        public void revert(){
            Node node = Head;
            Node temp = null;
            Head = Tail;
            Tail = temp;
            while (node!= null){
                temp = node.next;
                node.next=node.prev;
                node.prev = temp;
                node=node.prev;

            }
        }
        //----------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        dList list = new dList();

        list.pushBack(0);
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.pushBack(5);
        list.pushBack(6);
        list.pushBack(7);
        list.pushBack(8);
        list.pushBack(9);

        list.print();
        System.out.println();

        list.revert();
        list.print();

    }}

     }

