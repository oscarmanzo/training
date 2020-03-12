package com.globant.google.nest;

public class Node {
    int value;
    private Node left;
    private Node right;
    Node next;

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