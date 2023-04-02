package hw8.hw8.redblacktree;

import hw8.hw8.redblacktree.Node;

//Red-black tree implementation
public class RedBlackTree<Key extends Comparable<Key>, Value> {
	
	private Node<Key, Value> root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private int steps = 1;
	
	//Used to retrieve a value associated with a given key
	public Value get(Key key) {
		
		int step = 1;;
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
		steps = step-1;
		return null;							
	}
	
	//Orient a right-leaning red link to lean left 
	private Node<Key, Value> rotateLeft(Node<Key, Value> h) {
		Node<Key, Value> x = h.right;			
		h.right = x.left;						
		x.left = h;								
		x.color = h.color;						
		h.color = RED;							
		return x;								
	}
	
	//Orient a left-leaning red link to lean right 
	private Node<Key, Value> rotateRight(Node<Key, Value> h) {
		Node<Key, Value> x = h.left;			
		h.left= x.right;						
		x.right= h;							
		x.color = h.color;						
		h.color = RED;							
		return x;								
	}
	
	//Split a 4-node 
	private void flipColors(Node<Key, Value> h) {
		h.color = RED;					
		h.right.color = BLACK;			
		h.left.color = BLACK;			
	}
	
	//Return whether a given node has a red link 
	private boolean isRed(Node<Key, Value> x) {
		if (x == null) {				
			return false;				
		}
		return x.color == RED;			
	}
	
	//Add a value to the red-black tree under a given key 
	public void put(Key key, Value value) {
		root = put(root, key, value);												
	}
	
	//Private put() method 
	private Node<Key, Value> put(Node<Key, Value> h, Key key, Value value) {
		if (h == null) {															
			return new Node<Key, Value>(key, value, RED);							
		}
		
		int cmp = key.compareTo(h.key);												
		if (cmp < 0) {																
			h.left = put(h.left, key, value);									
		} else if (cmp > 0) {														
			h.right = put(h.right, key, value);								
		} else {																
			h.value = value;												
		}
		
		//Color balancing 
		if (isRed(h.right) && !isRed(h.left)) {									
			h = rotateLeft(h);														
		}
		if (isRed(h.left) && isRed(h.left.left)) {									
			h = rotateRight(h);													
		}
		if (isRed(h.left) && isRed(h.right)) {										
			flipColors(h);														
		}
		
		return h;																	
	}
	
	//Getter for steps used to see how many steps were taken to find a key within the tree
	public int getSteps() {
		return steps;
	}

}