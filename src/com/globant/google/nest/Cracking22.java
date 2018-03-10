package com.globant.google.nest;

/**
 * 2.2 Implement an algorithm to find the nth to last element of a singly linked list.
 * O(n) :  recorrido simple de los nodos
 **/
public class Cracking22 {

    public static void main(String[] args){
        Cracking22 app = new Cracking22();
        app.execute();
    }

    public void execute(){
        Node node = new Node(5);
        node.add(4).add(3).add(2).add(1);

        System.out.println("size:"+ node.size());
        print(node);
        
        System.out.println("++++++++++++++++++");        
        
        Node sub = find(node, 4);
        
        if (sub!=null){
            System.out.println("size:"+ sub.size());
            print(sub);
        }else{
            System.out.println("indice invalida");
        }
    }

    public Node find(Node node, int index){
        
        if (index <= 0) return null;
        if (index > node.size()) return null;

        if (index==1) return node;

        int count = 1;
        Node sub = node;

        while (sub.next!=null){
            sub = sub.next;
            count++;

            if (count == index) break;
        }

        return sub;
    }

    public void print(Node node){
        Node temp = node;
        System.out.println(temp.data);
        
        while (temp.next!=null){
            temp = temp.next;
            System.out.println(temp.data);
        }
    }

    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
        
        public Node add(int data){
            Node node = new Node(data);

            Node temp = this;

            while (temp.next !=null){
                temp = temp.next;
            }

            temp.next = node;
            
            return node;
        }
        
        public int size(){
            int size = 0;

            Node temp = this;
            size++;

            while (temp.next !=null){
                temp = temp.next;
                size++;
            }

            return size;
        }
        
    }

}
