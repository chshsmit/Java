//Tree.java
//Implements binary trees to store data

import static java.lang.System.*;
import java.util.*;

class Tree {

    private class Node {
        String key;
        Queue<Integer> value;
        Node left;
        Node right;
    }
    private Node root;

    private void debugHelper(Node tree, int depth) {
    
        
        if(tree != null){
            ++depth;
            debugHelper(tree.right, depth);
            for(int i = 0; i <((depth-1)*2); i++){
                System.out.print(" ");
            }
            System.out.println((depth-1)+ " " +tree.key);
            debugHelper(tree.left, depth);
        } 
       
    }

    private void outputHelper(Node tree) {
        
        if(tree != null){
            Iterator<Integer> iterator = tree.value.iterator();
            outputHelper(tree.right);

            System.out.print(tree.key+": ");
            while(iterator.hasNext()){
                System.out.print(iterator.next()+ " ");
            }
            System.out.println();
            outputHelper(tree.left);
        }
    }

    public void insert(String key, Integer linenum) {
        // Insert a word into the tree
        
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = new Queue<Integer>();
        


        if(root == null){
            root = newNode;
            root.value.insert(linenum);
        }
        else{
            Node current = root;
            Node parent;

            while(true){
                parent = current;
                
                if(key.compareTo(current.key) == 0){
                    current.value.insert(linenum);
                    return;
                }
                else if(key.compareTo(current.key) > 0){
                    current = current.left;

                    if(current == null){
                        parent.left = newNode;
                        parent.left.value.insert(linenum);
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        parent.right.value.insert(linenum);
                        return;
                    }
                }
            }
        }
    }

    public void debug() {
        // Show debug output of tree
        debugHelper(root, 0);
    }

    public void output() {
        // Show sorted words with lines where each word appears
        outputHelper(root);
    }

}
