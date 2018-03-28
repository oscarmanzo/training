package com.globant.google.nest;

public class MyTree {
    
    private Node root;

    public MyTree(){}

    public static void main(String[] args){
        MyTree tree = new MyTree();
        tree.add(3).add(1).add(2).add(5).add(4).add(6);

        MyTree.printInorder(tree.getRoot());
    }

    public Node getRoot(){
        return this.root;
    }

    public MyTree add(int value){
        return add(Node.getInstance(value));
    }

    public MyTree add(Node node){

        if (node==null) throw new IllegalArgumentException("Node required.!");

        if (this.root == null){
            this.root = node;
            return this;
        }

        addDeep(this.root, node);

        return this;
    }

    private void addDeep(Node parent, Node child){
        
        if (parent.getValue() > child.getValue()){
            
            if (parent.getLeft()==null){
                parent.setLeft(child);
            } else {
                addDeep(parent.getLeft(), child);
            }        
        } else {
            if (parent.getRight()==null){
                parent.setRight(child);
            } else {
                addDeep(parent.getRight(), child);
            }
        }
    }

    public boolean isEmpty(){
        return this.root == null;
    }
    
    public static void printInorder(Node parent){
        if (parent==null) return;

        if (parent.getLeft()!=null)
            printInorder(parent.getLeft());
        
        System.out.print(parent.getValue());
        
        if (parent.getRight()!=null)
            printInorder(parent.getRight());
    }

}

class Node {

    private int value;
    private Node left;
    private Node right;
    
    public Node(int value){
       this.value = value;
    }

    public static Node getInstance(int value){
        return new Node(value);
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }
    
    public int getValue(){
        return this.value;
    }

    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }

}
