package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        final RBTree tree = new RBTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                int value = Integer.parseInt(reader.readLine());
                tree.add(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static class  RBTree{
        private Node root;

        public boolean add (int value) {
            boolean result = false;
            if (root != null) {
                result = addNode(root, value);
                root = rebalance(root);
                root.color = Node.Color.Black;
                return result;
            } else {
                root = new Node();
                root.color = Node.Color.Black;
                root.value = value;
                return result;
            }

        }
        private boolean addNode(Node node, int value) {
            if (node.value == value) {
                return false;
            } else {
                if (node.value > value) {
                    if (node.LeftChildren != null) {
                        boolean result = addNode(node.LeftChildren, value);
                        node.LeftChildren = rebalance(node.LeftChildren);
                        return true;
                    }else {
                        node.LeftChildren = new Node();
                        node.LeftChildren.color = Node.Color.Red;
                        node.LeftChildren.value = value;
                        return true;
                            }
                }else{
                  if (node.RightChildren!=null){
                      boolean result  = addNode(node.RightChildren, value);
                      node.RightChildren = rebalance(node.RightChildren);
                      return true;
                  }else{
                      node.RightChildren = new Node();
                      node.RightChildren.color = Node.Color.Red;
                      node.RightChildren.value = value;
                      return true;
                  }

                        }
            }}
        private void colorSwap(Node node){
                node.RightChildren.color = Node.Color.Black;
                node.LeftChildren.color = Node.Color.Black;
                node.color = Node.Color.Red;
            }
        private Node rightSwap(Node node){
            Node rightChildren = node.RightChildren;
            Node temp = rightChildren.LeftChildren;
            rightChildren.LeftChildren = node;
            node.RightChildren = temp;
            rightChildren.color = node.color;
            node.color = Node.Color.Red;
            return rightChildren;
        }
        private Node leftSwap(Node node){
            Node leftChildren = node.LeftChildren;
            Node temp = leftChildren.RightChildren;
            leftChildren.RightChildren = node;
            node.LeftChildren = temp;
            leftChildren.color = node.color;
            node.color = Node.Color.Red;
            return leftChildren;
        }


        private Node rebalance(Node node) {
            Node result = node;
            boolean needRebalance;
            do{
                needRebalance = false;
                if (result.RightChildren !=null && result.RightChildren.color == Node.Color.Red &&
                        (result.LeftChildren == null || result.LeftChildren.color == Node.Color.Black)) {
                    needRebalance = true;
                    result = rightSwap(result);
                }
                if (result.LeftChildren !=null && result.LeftChildren.color == Node.Color.Red &&
                  result.LeftChildren.LeftChildren != null && result.LeftChildren.LeftChildren.color == Node.Color.Red){
                    needRebalance = true;
                    result = leftSwap(result);
                }
                if (result.LeftChildren != null && result.LeftChildren.color == Node.Color.Red){
                    needRebalance = true;
                    colorSwap(result);
                }
            } while (needRebalance);
            return  result;
        }}

        private static class Node {
        int value;

        private Node LeftChildren;
        private Node RightChildren;
        private Node Parent;
        private  Color color;
        private  enum Color{
            Red,
            Black
        }

//        public Node(int value) {
//            this.value = value;
//        }
        public String toString(){
            return "Node { value = " + this.value + "color = " + this.color;
        }
        }

}