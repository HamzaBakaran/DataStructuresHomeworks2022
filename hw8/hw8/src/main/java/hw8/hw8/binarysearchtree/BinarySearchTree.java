package hw8.hw8.binarysearchtree;

import hw8.hw8.binarysearchtree.Node;

//Binary search tree implementation
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private Node<Key, Value> root;
	private int steps = 1;
	
	//Used to retrieve a value associated with a given key 
	public Value get(Key key) {
		
		int step = 1;
		Node<Key, Value> x = root;			
		
		while (x != null) {			
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {					
				x = x.left;
				step++;
			} else if (cmp > 0) { 
				x = x.right;
				step++;
			} else {				
				steps = step;
				return x.value;
			}	
		}
		
		steps = step;
		return null;					
	}
	
	//Used to return the size of the tree
	public int size() {
		return size(root);			
	}
	
	//Private size() method
	private int size(Node<Key, Value> x) {	
		if (x == null) {							
			return 0;						
		}
		return x.size;								
	}
	
	//Adds a value to the tree under a given key
	public void put(Key key, Value value) {
		root = put(root, key, value);							
	}
	
	//Private put() method
	private Node<Key, Value> put(Node<Key, Value> x, Key key, Value value) {		
		if (x == null) {														
			return new Node<Key, Value>(key, value);								
		}
		
		int cmp = key.compareTo(x.key);									
		if (cmp < 0) {															
			x.left = put(x.left, key, value);						
		} else if (cmp > 0) {									
			x.right = put(x.right, key, value);							
		} else {													
			x.value = value;											
		}
		
		x.size = 1 + size(x.left) + size(x.right);						
		return x;												
	}
	
	//Used to find the minimum key in the tree
	public Key findMin() {  
	   return findMin(root).key; 					
	}	
	
	//Private findMin() method 
	private Node<Key, Value> findMin(Node<Key, Value> x) {
	   if (x.left == null) {									
		   return x;											
	   }
	   return findMin(x.left);										
	}
	
	//Used to find the maximum key in the tree
	public Key findMax() {  
		return findMax(root).key; 			
	}
	
	//Private findMax() method 
	private Node<Key, Value> findMax(Node<Key, Value> x) {
		if (x.right == null) {								
			return x;							
		}
		return findMax(x.right);						
	}
	
	//Used to find the rank of a given key 
	public int rank(Key key) {						
		return rank(root, key);								
	}	
	
	//Private rank() method 
	private int rank(Node<Key, Value> x, Key key) {
		if (x == null) {								
			return 0;										
		}
		
		int cmp = key.compareTo(x.key);						
		if (cmp < 0) {								
			return rank(x.left, key);					
		} else if (cmp > 0) {						
			return 1 + size(x.left) + rank(x.right, key);
		} else {									
			return size(x.left);				
		}
	}
	
	//Used to delete the node with the minimum key 
	public void deleteMin() {
		root = deleteMin(root);									
	}
	
	//Private deleteMin() method 
	private Node<Key, Value> deleteMin(Node<Key, Value> x) {
		if (x.left == null) {							
			return x.right;							
		}
		
		x.left = deleteMin(x.left);						
		x.size = 1 + size(x.left) + size(x.right);		
		
		return x;							
	}
	
	//Used to delete a node with the given key 
	public void delete(Key key) {
		root = delete(root, key);								
	}
	
	// Private delete() method 
	private Node<Key, Value> delete(Node<Key, Value> x, Key key) {
		if (x == null) {									
			return null;											
		}
		
		int cmp = key.compareTo(x.key);							
		if (cmp < 0) {													
			x.left = delete(x.left, key);								
		} else if (cmp > 0) {										
			x.right = delete(x.right, key);								
		} else {												
			if (x.right == null) {			
				return x.left;								
			}
			if (x.left == null) {						
				return x.right;									
			}
			
			Node<Key, Value> t = x;					
			x = findMin(t.right);							
			x.right = deleteMin(t.right);			
			x.left = t.left;						
		}
		x.size = 1 + size(x.left) + size(x.right);					
		return x;														
	}

	//Getter for steps used to see how many steps were taken to find a key within the tree
	public int getSteps() {
		return steps;
	}
}
