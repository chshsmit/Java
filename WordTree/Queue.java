//Queue.java
//Implements queue of line numbers for binary tree 

import java.util.Iterator;
import java.util.NoSuchElementException;

class Queue <Item> implements Iterable <Item> {

   private class Node {
      Item item;
      Node next;
   }
   private Node head = null;
   private Node tail = null;
   private Node current;

   public boolean isempty() {
      if(head == null){
         return true;
      }
      return false;
   }

   public void insert(Item newitem) {

      if(isempty()){
         Node newNode = new Node();
         newNode.item = newitem;
         newNode.next = tail;
         head = newNode;
         current = head;
         //System.out.println(current.item); 
      }else{
         Node newNode = new Node();
         newNode.item = newitem;
         newNode.next = tail;
         current.next = newNode;
         current = newNode;
         //System.out.println(current.item);
      }
   }

   public Iterator <Item> iterator() {
      return new Itor ();
   }

   class Itor implements Iterator <Item> {
      Node current = head;
      public boolean hasNext() {
         return current != null;
      }
      public Item next() {
         if (! hasNext ()) throw new NoSuchElementException();
         Item result = current.item;
         current = current.next;
         return result;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

}
