package com.globant.google.nest;

public class MyLinkedList {

    private Node head = null;

    public MyLinkedList(){
        this.head = Node.getInstance(0);
    }

    public void add(int data){
        Node node = Node.getInstance(data);

        Node temp = this.head;

        while (temp.next !=null){
            temp = temp.next;
        }

        temp.next = node;
    }

    public void remove(Node node){

        Node temp = this.head;

        while (temp.next !=null){

            if (temp.next == node){

                if (temp.next.next !=null){
                    temp.next = temp.next.next;
                }else {
                    temp.next = null;
                }

                break;
            }

            temp = temp.next;
        }
    }

    public int size(){
        int size = 0;

        if (this.head==null || this.head.next == null) return size;

        Node temp = this.head;

        while (temp.next !=null){
            temp = temp.next;
            size++;
        }

        return size;
    }

    public Node getHead(){
        return this.head;
    }

    public MyIterator getIterator(){
        MyIterator iterator = new MyIterator(this.head);
        return iterator;
    }

    class MyIterator {
        Node head;

        MyIterator(Node head){
            this.head = head;
        }

        public boolean hasNext(){
            return this.head.next!=null;
        }

        public Node next(){
            if (this.head==null) return null;

            Node temp = this.head.next;
            this.head = this.head.next;
            return temp;
        }
    }

}
