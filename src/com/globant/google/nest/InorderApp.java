package com.globant.google.nest;

public class InorderApp {

    public static void main(String[] args){
        InorderApp app = new InorderApp();
        app.execute();
    }

    public void execute(){
        Node root = buildTree();
        
        System.out.println("Inorder");
        printInorder(root);
        System.out.println();
        
        System.out.println("Preorder");
        printPreorder(root);
        System.out.println();
        
        System.out.println("Postorder");
        printPostorder(root);
        System.out.println();
    }

    public Node buildTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        return root;
    }

    public void printInorder(Node root){
        if (root==null) return;

        if (root.left!=null) printInorder(root.left);
        System.out.print(root.data);
        if (root.right!=null) printInorder(root.right);
    }

    public void printPreorder(Node root){
        if (root==null) return;

        System.out.print(root.data);
        if (root.left!=null) printPreorder(root.left);
        if (root.right!=null) printPreorder(root.right);
    }

    public void printPostorder(Node root){
        if (root==null) return;

        if (root.left!=null) printPostorder(root.left);
        if (root.right!=null) printPostorder(root.right);
        System.out.print(root.data);
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
        
    } // Node

}
