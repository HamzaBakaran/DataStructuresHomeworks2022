package ibu.edu.hw1;

//Stack class for Algorithm implementation
public class Stack<Item> {
	
	private Node<Item> top;
	private int length;
	
	public Stack() {
		this.top = null;
		this.length = 0;
	}
	
  public void push(Item item) {
      Node<Item> newNode = new Node<Item>();  
      newNode.data = item;                    
      newNode.next = top;                     
      top = newNode;                          
      length++;                               
  }
  
  public Item pop() {                                                      
      if (isEmpty()) {                                                    
          throw new IndexOutOfBoundsException("The stack is empty.");     
      }                                                                   
      Item item = top.data;                                               
      top = top.next;                                                     
      length--;                                                           
      return item;                                                        
  }
  
  public boolean isEmpty() {
      return top == null;
  }
      
  public int size() {
      return length;
  }
}
