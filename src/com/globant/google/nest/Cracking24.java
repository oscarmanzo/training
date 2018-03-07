package com.globant.google.nest;

public class Cracking24 {

    public static void main(String[] args){
        Cracking24 app = new Cracking24();
        app.execute();
    }

    public Node execute(){
        Node list1 = new Node(5);
        list1.add(1).add(3);

        Node list2 = new Node(2);
        list2.add(9).add(5);

        System.out.println("++++++++++++ list1 +++++++++++");
        print(list1);

        System.out.println("++++++++++++ list2 +++++++++++");
        print(list2);
                
        Node listTotal = sum(list1, list2);
        print(listTotal);
        
        return listTotal;
    }

    public Node sum(Node list1, Node list2){

        int num1 = toNum(list1);
        int num2 = toNum(list2);
        int total = num1 + num2;

        System.out.println("sum: "+ total);
        
        Node listTotal = toList(String.valueOf(total));

        return listTotal;
    }

    public Node toList(String num){
        char[] chars = num.toCharArray();

        Node list = null;
        
        for (int i=0; i<chars.length; i++){
            char c = chars[i];
            int x = Integer.valueOf(""+ c);
            
            if (i==0)
                list = new Node(x);
            else
                list.add(x);
        }
        
        return list;
    }

    public int toNum(Node node){
        String num = "";
        
        Node temp = node;
        num += temp.data;
        
        while (temp.next!=null){
            temp = temp.next;
            num += temp.data;
        }
        
        return Integer.valueOf(num);
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
