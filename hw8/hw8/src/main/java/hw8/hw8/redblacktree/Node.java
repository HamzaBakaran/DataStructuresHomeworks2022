package hw8.hw8.redblacktree;



//Node class used to implement the red-black tree
public class Node<Key extends Comparable<Key>, Value> {
	
	public Key key;             			
	public Value value;            			
	public Node<Key, Value> left, right;    
	public boolean color;					
	
	/* Node constructor */
	public Node(Key key, Value value, boolean color) {
		this.key = key;
		this.value = value;
		this.color = color;
	}
	 
}
