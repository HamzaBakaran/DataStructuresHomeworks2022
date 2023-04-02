package hw8.hw8.binarysearchtree;


//Node class used to implement the binary search tree
public class Node<Key extends Comparable<Key>, Value> {
	
	   public Key key;             				
	   public Value value;            			
	   public Node<Key, Value> left, right;    
	   public int size = 1;                		
	   
	   /* Node constructor */
	   public Node(Key key, Value value) {
		   this.key = key;
		   this.value = value;
	   }
	}

