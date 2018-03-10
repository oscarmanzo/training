package com.globant.google.nest;

/**
 * 2.1 Write code to remove duplicates from an unsorted linked list.
 * O(n) : se cuenta con 4 ciclos de la coleccion
 */
public class Cracking21 {

    public static void main(String[] args){
        Cracking21 app = new Cracking21();
        app.execute();
    }    
    
    public void execute(){
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(4);
        list.add(3);
        
        System.out.println("size:"+ list.size());
        
        Node head = list.getHead();
        
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
            System.out.println(temp.data);
        
        
            Node tempInner = head;
            while (tempInner.next!=null){
                tempInner = tempInner.next;
                
                if (temp != tempInner && temp.data == tempInner.data){
                    list.remove(tempInner);
                }
            }
        }
        
        /*
        System.out.println("----------------------------------------------");
        MyLinkedList.MyIterator iterator = list.getIterator();
        while (iterator.hasNext()){
            Node node = iterator.next();
            System.out.println(node.data);
            
            MyLinkedList.MyIterator iteratorInner = list.getIterator();

           while (iteratorInner.hasNext()){
                Node nodeInner = iterator.next();
                
                if (nodeInner!=null && node != nodeInner && node.data == nodeInner.data){
                    list.remove(nodeInner);
                }
           }
        }
        */
        
        System.out.println("size:"+ list.size());
        
    }

}

class MyLinkedList {
    
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

class Node {
    Node next;
    int data;
    
    public static Node getInstance(int data){
        Node node = new Node();
        node.data = data;
        return node;
    }
}