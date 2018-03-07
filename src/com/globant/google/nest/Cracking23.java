package com.globant.google.nest;

public class Cracking23 {

    public static void main(String[] args){
        Cracking23 app = new Cracking23();
        app.execute();
    }

    public void execute(){
        Node list = new Node(5);
        list.add(4).add(3).add(2).add(1);

        System.out.println("++++++++++++ list +++++++++++");
        System.out.println("size:"+ list.size());
        print(list);
        
        System.out.println("++++++++++++ get +++++++++++");
        int index = 2;
        Node subnode = list.get(index);
        System.out.println("get("+ index +"):"+ subnode.data);
        
        System.out.println("++++++++++++ remove +++++++++++");
        list.remove(subnode);
        System.out.println("size:"+ list.size());
        print(list);        
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

        public void remove(Node node){
    
            Node temp = this;
    
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

            Node temp = this;
            size++;

            while (temp.next !=null){
                temp = temp.next;
                size++;
            }

            return size;
        }

        public Node get(int index){
            
            if (index <= 0) return null;
            if (index > this.size()) return null;
    
            if (index==1) return this;
    
            int count = 1;
            Node sub = this;
    
            while (sub.next!=null){
                sub = sub.next;
                count++;
    
                if (count == index) break;
            }
    
            return sub;
        }

    }

}
