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
            System.out.println(temp.value);
        
        
            Node tempInner = head;
            while (tempInner.next!=null){
                tempInner = tempInner.next;
                
                if (temp != tempInner && temp.value == tempInner.value){
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
